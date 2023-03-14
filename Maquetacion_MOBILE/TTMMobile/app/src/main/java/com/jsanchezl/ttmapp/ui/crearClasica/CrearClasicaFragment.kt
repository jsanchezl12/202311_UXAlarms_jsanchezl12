package com.jsanchezl.ttmapp.ui.crearClasica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
        /*
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}