package com.jsanchezl.ttmapp.ui.crearNVoz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.jsanchezl.ttmapp.databinding.FragmentCrearNotavozBinding
import com.jsanchezl.ttmapp.R
import com.jsanchezl.ttmapp.ui.crearNVoz.CNVozViewModel

class CrearNotaVozFragment : Fragment(){
    private var _binding: FragmentCrearNotavozBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(CNVozViewModel::class.java)

        _binding = FragmentCrearNotavozBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val items = arrayOf("","Clásica", "Nota de Voz", "Reconocimiento Por Voz")
        val adapter = activity?.applicationContext?.let { ArrayAdapter(it, R.layout.spinner_item, items) } as SpinnerAdapter
        val alarmsTypeSpinner: Spinner = binding.SPAlarmsTypes
        alarmsTypeSpinner.adapter = adapter
        alarmsTypeSpinner.setSelection(2)
        alarmsTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Handle item selection
                val msg: String = items[position];
                //Toast.makeText(activity, "Opcion: " + msg, Toast.LENGTH_SHORT).show()
                if( msg == "Clásica") {
                    findNavController().navigate(R.id.action_nvoz_to_clasica)
                }else if( msg == "Nota de Voz"){

                }else if (msg == "Reconocimiento Por Voz"){
                    findNavController().navigate(R.id.action_nvoz_to_rvoz)
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
