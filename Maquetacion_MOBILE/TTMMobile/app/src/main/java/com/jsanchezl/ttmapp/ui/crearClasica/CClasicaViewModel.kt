package com.jsanchezl.ttmapp.ui.crearClasica

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CClasicaViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Crear Clasica Fragment"
    }
    val text: LiveData<String> = _text
}