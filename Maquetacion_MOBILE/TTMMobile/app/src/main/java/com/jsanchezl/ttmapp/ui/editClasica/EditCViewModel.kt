package com.jsanchezl.ttmapp.ui.editClasica

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EditCViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Modificar Clasica Fragment"
    }
    val text: LiveData<String> = _text
}