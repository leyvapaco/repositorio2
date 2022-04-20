package com.example.miaplicacion.second

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.miaplicacion.network.MiApi
import com.example.miaplicacion.network.MiAplicacionProperty
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class SecondViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the most recent response status
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the status String
    val status: LiveData<String>
        get() = _status

    // Internally, we use a MutableLiveData, because we will be updating the MarsProperty with
    // new values
    private val _property = MutableLiveData<MiAplicacionProperty>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val property: LiveData<MiAplicacionProperty>
        get() = _property


    // The external LiveData interface to the property is immutable, so only this class can modify
    val miTexto= MutableLiveData<String>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val miTel= MutableLiveData<String>()

    init {
        miTexto.value=""

        miTel.value=""

       getUserProperties()
      }


    private fun getUserProperties() {
        viewModelScope.launch {
            try {
                var listResult = MiApi.retrofitService.getProperties()
                _status.value = "Success: ${listResult.size} User properties retrieved"
                if (listResult.size > 0) {
                    _property.value = listResult[0]
                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }

    }

    /**
     */
}
