package com.jsanchezl.ttmapp.ui.eventsLista

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EventsLViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Eventos Lista Fragment"
    }
    val text: LiveData<String> = _text
}