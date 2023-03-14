package com.jsanchezl.ttmapp.ui.crearClasica

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.jsanchezl.ttmapp.MainActivity
import com.jsanchezl.ttmapp.databinding.FragmentHomeBinding
import com.jsanchezl.ttmapp.databinding.FragmentCrearClasicaBinding
import com.jsanchezl.ttmapp.ui.crearClasica.CClasicaViewModel

class CrearClasicaFragment : Fragment(){

    private var _binding: FragmentCrearClasicaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(CClasicaViewModel::class.java)

        _binding = FragmentCrearClasicaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val navController = this.activity?.findNavController(R.id.navigationBarBackground)

        val items = arrayOf("","Clásica", "Nota de Voz", "Reconocimiento Por Voz")
        val adapter = activity?.applicationContext?.let { ArrayAdapter(it, R.layout.simple_spinner_dropdown_item, items) } as SpinnerAdapter
        val alarmsTypeSpinner: Spinner = binding.SPAlarmsTypes
        alarmsTypeSpinner.adapter = adapter

        alarmsTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Handle item selection
                val msg: String = items[position];
                Toast.makeText(activity, "Opcion: " + msg, Toast.LENGTH_SHORT).show()
                //navController.navigate(R.id.action_clasica_to_nvoz)
                // root.findViewById(R.id.action_clasica_to_nvoz)
                // Navigation.findNavController(root).navigate(R.id.action_clasica_to_nvoz)
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