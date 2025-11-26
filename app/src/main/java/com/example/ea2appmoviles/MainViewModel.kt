package com.example.ea2appmoviles

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ea2appmoviles.model.Clasificacion
import com.example.ea2appmoviles.model.Equipo
import com.example.ea2appmoviles.model.Fecha
import com.example.ea2appmoviles.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _equipos = MutableStateFlow<List<Equipo>>(emptyList())
    val equipos: StateFlow<List<Equipo>> = _equipos

    private val _clasificacion = MutableStateFlow<List<Clasificacion>>(emptyList())
    val clasificacion: StateFlow<List<Clasificacion>> = _clasificacion

    private val _fechas = MutableStateFlow<List<Fecha>>(emptyList())
    val fechas: StateFlow<List<Fecha>> = _fechas

    private fun clearAll() {
        _equipos.value = emptyList()
        _clasificacion.value = emptyList()
        _fechas.value = emptyList()
    }

    fun getEquipos() {
        viewModelScope.launch {
            clearAll()
            try {
                val response = RetrofitInstance.api.getEquipos()
                _equipos.value = response
                Log.d("MainViewModel", "Equipos cargados: ${response.size}")
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error al cargar equipos", e)
            }
        }
    }

    fun getClasificacion() {
        viewModelScope.launch {
            clearAll()
            try {
                val response = RetrofitInstance.api.getClasificacion()
                _clasificacion.value = response
                Log.d("MainViewModel", "Clasificación cargada: ${response.size}")
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error al cargar clasificación", e)
            }
        }
    }

    fun getFechas() {
        viewModelScope.launch {
            clearAll()
            try {
                val response = RetrofitInstance.api.getFechas()
                _fechas.value = response
                Log.d("MainViewModel", "Fechas cargadas: ${response.size}")
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error al cargar fechas", e)
            }
        }
    }
}
