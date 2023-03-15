package com.jsanchezl.ttmapp.repositories

import android.app.Application
import com.android.volley.VolleyError
import com.jsanchezl.ttmapp.models.Alarma
import org.json.JSONObject

class AlarmRepository (val application: Application){
    val alarmas:  MutableList<Alarma> = mutableListOf(
        Alarma(0, "Sacar al Perro", "6:00 AM", "Diario"),
        Alarma(1, "Reunion Jefe", "8:00 AM", "Diario"),
        Alarma(2, "Comprar Leche", "10:00 AM", "Lunes"),
        Alarma(3, "Comprar Huevos", "10:00 AM", "Martes"),
        Alarma(4, "Pagar Recibo Agua", "1:00 PM", "Hoy"),
        Alarma(5, "Pagar Celular", "1:00 PM", "Hoy"),
        Alarma(6, "Clase", "5:00 PM", "Martes"),
        Alarma(7, "Parcial", "7:00 PM", "Jueves")
    )
    fun refreshData(callback: (List<Alarma>)->Unit, onError: (VolleyError)->Unit) {
        callback(alarmas)
    }

    fun postData(body: JSONObject ,callback: (JSONObject)->Unit, onError: (VolleyError) -> Unit){
        alarmas.add(Alarma(alarmas.size, "Sacar al Perro", "6:00 AM", "Diario"))
    }

}