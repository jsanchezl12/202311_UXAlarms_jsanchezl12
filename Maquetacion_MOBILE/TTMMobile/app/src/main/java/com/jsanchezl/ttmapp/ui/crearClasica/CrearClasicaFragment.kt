package com.jsanchezl.ttmapp.ui.crearClasica


import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.jsanchezl.ttmapp.R

import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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
        val homeViewModel = ViewModelProvider(this).get(CClasicaViewModel::class.java)
        _binding = FragmentCrearClasicaBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val items = arrayOf("","Clásica", "Nota de Voz", "Reconocimiento Por Voz")
        val adapter = activity?.applicationContext?.let { ArrayAdapter(it, R.layout.spinner_item, items) } as SpinnerAdapter
        val alarmsTypeSpinner: Spinner = binding.SPAlarmsTypes
        alarmsTypeSpinner.adapter = adapter
        alarmsTypeSpinner.setSelection(1)

        alarmsTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Handle item selection
                val msg: String = items[position];
                //Toast.makeText(activity, "Opcion: " + msg, Toast.LENGTH_SHORT).show()
                if( msg == "Clásica") {

                }else if( msg == "Nota de Voz"){
                    findNavController().navigate(R.id.action_clasica_to_nvoz)
                }else if (msg == "Reconocimiento Por Voz"){
                    findNavController().navigate(R.id.action_clasica_to_rvoz)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        val btnCancelar: Button = binding.BtnCancelar
        btnCancelar.setOnClickListener {
            findNavController().navigate(R.id.action_clasica_to_home)
        }
        val btnCrear: Button = binding.BtnCrear
        btnCrear.setOnClickListener {
            findNavController().navigate(R.id.action_clasica_to_events_lista)
        }

        val ETFecha: EditText =  binding.ETFecha
        ETFecha.setOnClickListener{
            val currentDate = Calendar.getInstance()
            val year = currentDate.get(Calendar.YEAR)
            val month = currentDate.get(Calendar.MONTH)
            val day = currentDate.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(requireContext(),
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    // set the selected date on the EditText
                    val selectedDate = "$year-${monthOfYear + 1}-$dayOfMonth"
                    ETFecha.setText(selectedDate)
                }, year, month, day)
            datePickerDialog.show()
        }


        val ETRepetir: EditText = binding.ETRepetir
        ETRepetir.setOnClickListener{
            val daysOfWeek = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
            val dayAcronyms = arrayOf("LU", "MA", "MI", "JU", "VI", "SA", "DO")
            val selectedDays = booleanArrayOf(false, false, false, false, false, false, false)
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Selecciona dias para repetir")
            builder.setMultiChoiceItems(daysOfWeek, selectedDays) { _, which, isChecked ->
                selectedDays[which] = isChecked
            }
            val str_selected = mutableListOf<String>()
            builder.setPositiveButton("OK") { _, _ ->
                val selectedDaysOfWeek = mutableListOf<Int>()
                for (i in selectedDays.indices) {
                    if (selectedDays[i]) {
                        selectedDaysOfWeek.add(i)
                        str_selected.add(dayAcronyms[i])
                    }
                }
                //Toast.makeText(requireContext(), "Selected days: $selectedDaysOfWeek", Toast.LENGTH_SHORT).show()
                if(selectedDaysOfWeek.size == daysOfWeek.size){
                    ETRepetir.setText("Diario")
                }else {
                    ETRepetir.setText(str_selected.joinToString(separator = "-"))
                }
            }
            builder.setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
            val dialog = builder.create()
            dialog.show()
        }

        val ETSonido: EditText = binding.ETSonido
        ETSonido.setOnClickListener{
            val sonidos = arrayOf("Sonido 1", "Sonido 2", "Sonido 3", "Sonido 4", "Sonido 5", "Sonido 6", "Sonido 7")
            var selectedItem = -1
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Selecciona un sonido")
            builder.setSingleChoiceItems(sonidos, -1) { _, which ->
                selectedItem = which
            }
            builder.setPositiveButton("OK") { _, _ ->
                if (selectedItem != -1) {
                    val sonido = sonidos[selectedItem]
                    ETSonido.setText(sonido)
                }
            }
            builder.setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
            val dialog = builder.create()
            dialog.show()
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