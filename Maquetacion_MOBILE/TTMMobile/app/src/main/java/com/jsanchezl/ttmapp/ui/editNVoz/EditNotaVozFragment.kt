package com.jsanchezl.ttmapp.ui.editNVoz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.jsanchezl.ttmapp.R

import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.jsanchezl.ttmapp.databinding.FragmentEditNvozBinding
import com.jsanchezl.ttmapp.ui.editNVoz.EditNVViewModel

class EditNotaVozFragment : Fragment(){

    private var _binding: FragmentEditNvozBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(EditNVViewModel::class.java)
        _binding = FragmentEditNvozBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val items = arrayOf("","Clásica", "Nota de Voz")
        val adapter = activity?.applicationContext?.let { ArrayAdapter(it, R.layout.spinner_item, items) } as SpinnerAdapter
        val alarmsTypeSpinner: Spinner = binding.SPEAlarmsTypes
        alarmsTypeSpinner.adapter = adapter
        alarmsTypeSpinner.setSelection(2)

        alarmsTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Handle item selection
                val msg: String = items[position];
                //Toast.makeText(activity, "Opcion: " + msg, Toast.LENGTH_SHORT).show()
                if( msg == "Clásica") {
                    findNavController().navigate(R.id.action_envoz_to_eclasica)
                }else if( msg == "Nota de Voz"){

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        val btnCancelar: Button = binding.BtnCancelar
        btnCancelar.setOnClickListener {
            findNavController().navigate(R.id.action_envoz_to_home)
        }
        val btnModificar: Button = binding.BtnModificar
        btnModificar.setOnClickListener {
            findNavController().navigate(R.id.action_envoz_to_events_lista)
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}