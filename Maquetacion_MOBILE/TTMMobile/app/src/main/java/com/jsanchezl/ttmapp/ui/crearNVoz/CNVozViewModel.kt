package com.jsanchezl.ttmapp.ui.crearNVoz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CNVozViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Crear Nota de Voz Fragment"
    }
    val text: LiveData<String> = _text
}

