package com.jsanchezl.ttmapp.repositories

import android.app.Application
import com.android.volley.VolleyError
import com.jsanchezl.ttmapp.models.Alarma
import org.json.JSONObject

class AlarmRepository (val application: Application){
    val alarmas:  MutableList<Alarma> = mutableListOf(
        Alarma(0, "Sacar al Perro", "6:00 AM", "Diario", "C"),
        Alarma(1, "Reunion Jefe", "8:00 AM", "Diario", "NV"),
        Alarma(2, "Comprar Leche", "10:00 AM", "Lunes", "C"),
        Alarma(3, "Comprar Huevos", "10:00 AM", "Martes", "C"),
        Alarma(4, "Pagar Recibo Agua", "1:00 PM", "Hoy", "NV"),
        Alarma(5, "Pagar Celular", "1:00 PM", "Hoy", "NV"),
        Alarma(6, "Clase", "5:00 PM", "Martes", "NV"),
        Alarma(7, "Parcial", "7:00 PM", "Jueves", "NV")
    )
    fun refreshData(callback: (List<Alarma>)->Unit, onError: (VolleyError)->Unit) {
        callback(alarmas)
    }

    fun postData(body: JSONObject ,callback: (JSONObject)->Unit, onError: (VolleyError) -> Unit){
        alarmas.add(Alarma(alarmas.size, "Sacar al Perro", "6:00 AM", "Diario", "C"))
    }

}