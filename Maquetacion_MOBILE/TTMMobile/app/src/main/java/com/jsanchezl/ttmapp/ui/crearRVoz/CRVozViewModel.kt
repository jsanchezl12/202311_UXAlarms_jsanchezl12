package com.jsanchezl.ttmapp.ui.crearRVoz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
/*
class CRVozViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Crear por Reconocimiento de Voz Fragment"
    }
    val text: LiveData<String> = _text
}*/

import android.app.Application
import androidx.lifecycle.*
import com.android.volley.VolleyError
import com.jsanchezl.ttmapp.models.Alarma
import com.jsanchezl.ttmapp.repositories.AlarmRepository
import org.json.JSONObject

class CRVozViewModel(application: Application) :  AndroidViewModel(application) {
    private val alarmaRepository = AlarmRepository(application)
    private val _alarmas = MutableLiveData<List<Alarma>>()
    val alarmas: LiveData<List<Alarma>>
        get() = _alarmas

    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)

    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    init {
        refreshDataFromNetwork()
    }

    fun crearAlarma(body: JSONObject, callback: (JSONObject)->Unit, onError: (VolleyError)->Unit){
        alarmaRepository.postData(body, callback, onError)
    }

    fun refreshDataFromNetwork() {
        alarmaRepository.refreshData({
            _alarmas.postValue(it)
            _eventNetworkError.value = false
            _isNetworkErrorShown.value = false
        },{
            _eventNetworkError.value = true
        })
    }

    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CRVozViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CRVozViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }


}