package com.jsanchezl.ttmapp.ui.eventsCalendario

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EventsCViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Eventos Calendario Fragment"
    }
    val text: LiveData<String> = _text
}