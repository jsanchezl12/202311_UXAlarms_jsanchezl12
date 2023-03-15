package com.jsanchezl.ttmapp.ui.editNVoz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EditNVViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Modificar Nota de Voz Fragment"
    }
    val text: LiveData<String> = _text
}