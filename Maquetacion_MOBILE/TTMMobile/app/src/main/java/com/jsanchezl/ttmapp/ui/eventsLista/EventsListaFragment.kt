package com.jsanchezl.ttmapp.ui.eventsLista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jsanchezl.ttmapp.R
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsanchezl.ttmapp.models.Alarma
import androidx.lifecycle.Observer
import com.jsanchezl.ttmapp.databinding.FragmentEventsListaBinding
import com.jsanchezl.ttmapp.ui.adapters.EListaAdapter
import com.jsanchezl.ttmapp.ui.eventsLista.EventsLViewModel


class EventsListaFragment : Fragment(){
    private var _binding: FragmentEventsListaBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: EventsLViewModel
    private var viewModelAdapter: EListaAdapter? = null
    var rtimes: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventsListaBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModelAdapter = EListaAdapter()
        val root: View = binding.root
        val items = arrayOf("","Lista", "Calendario")
        val adapter = activity?.applicationContext?.let { ArrayAdapter(it, R.layout.spinner_item, items) } as SpinnerAdapter
        val alarmsTypeSpinner: Spinner = binding.SPEventosTypes
        alarmsTypeSpinner.adapter = adapter
        alarmsTypeSpinner.setSelection(1)
        alarmsTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Handle item selection
                val msg: String = items[position];
                if( msg == "Lista") {

                }else if( msg == "Calendario"){
                    findNavController().navigate(R.id.action_elista_to_ecalendario)
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.AlarmasRV
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = viewModelAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        viewModel = ViewModelProvider(this, EventsLViewModel.Factory(activity.application)).get(EventsLViewModel::class.java)
        viewModel.alarmas.observe(viewLifecycleOwner, Observer<List<Alarma>> {
            it.apply {
                viewModelAdapter!!.alarmas = this
            }
        })
        viewModel.eventNetworkError.observe(viewLifecycleOwner, Observer<Boolean> { isNetworkError ->
            if (isNetworkError) onNetworkError()
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        if(rtimes > 0) {
            viewModel.refreshDataFromNetwork()
        }
        rtimes++
    }

    private fun onNetworkError() {
        if(!viewModel.isNetworkErrorShown.value!!) {
            Toast.makeText(activity, "Network Error", Toast.LENGTH_LONG).show()
            viewModel.onNetworkErrorShown()
        }
    }

    fun mostrarMSJ(msj: String){
        Toast.makeText(getActivity(), msj, Toast.LENGTH_LONG).show()
    }
}