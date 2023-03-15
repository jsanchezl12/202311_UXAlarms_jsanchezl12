package com.jsanchezl.ttmapp.ui.crearRVoz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsanchezl.ttmapp.R
import com.jsanchezl.ttmapp.databinding.FragmentCrearRecvozBinding
import com.jsanchezl.ttmapp.models.Alarma
import com.jsanchezl.ttmapp.ui.adapters.CRVozAdapter

class CrearReconocimientoVozFragment : Fragment() {
    private var _binding: FragmentCrearRecvozBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: CRVozViewModel
    private var viewModelAdapter: CRVozAdapter? = null
    var rtimes: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCrearRecvozBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModelAdapter = CRVozAdapter()
        val items = arrayOf("","Clásica", "Nota de Voz", "Reconocimiento Por Voz")
        val adapter = activity?.applicationContext?.let { ArrayAdapter(it, R.layout.spinner_item, items) } as SpinnerAdapter
        val alarmsTypeSpinner: Spinner = binding.SPAlarmsTypes
        alarmsTypeSpinner.adapter = adapter
        alarmsTypeSpinner.setSelection(3)
        alarmsTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Handle item selection
                val msg: String = items[position];
                //Toast.makeText(activity, "Opcion: " + msg, Toast.LENGTH_SHORT).show()
                if( msg == "Clásica") {
                    findNavController().navigate(com.jsanchezl.ttmapp.R.id.action_rvoz_to_clasica)
                }else if( msg == "Nota de Voz"){
                    findNavController().navigate(com.jsanchezl.ttmapp.R.id.action_rvoz_to_nvoz)
                }else if (msg == "Reconocimiento Por Voz"){

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
        return view
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
        viewModel = ViewModelProvider(this, CRVozViewModel.Factory(activity.application)).get(CRVozViewModel::class.java)
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