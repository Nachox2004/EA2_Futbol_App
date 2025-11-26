package com.example.ea2appmoviles

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ea2appmoviles.model.ClasificacionUi
import com.example.ea2appmoviles.model.Equipo
import com.example.ea2appmoviles.model.FechaUi
import com.example.ea2appmoviles.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _equipos = MutableStateFlow<List<Equipo>>(emptyList())
    val equipos: StateFlow<List<Equipo>> = _equipos

    private val _clasificacionUi = MutableStateFlow<List<ClasificacionUi>>(emptyList())
    val clasificacionUi: StateFlow<List<ClasificacionUi>> = _clasificacionUi

    private val _fechasUi = MutableStateFlow<List<FechaUi>>(emptyList())
    val fechasUi: StateFlow<List<FechaUi>> = _fechasUi

    private fun clearAll() {
        _equipos.value = emptyList()
        _clasificacionUi.value = emptyList()
        _fechasUi.value = emptyList()
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
                val equipos = RetrofitInstance.api.getEquipos()
                val equipoMap = equipos.associateBy({ it.id }, { it.nombre })
                val clasificacion = RetrofitInstance.api.getClasificacion()

                val clasificacionUi = clasificacion.mapNotNull { clasif ->
                    val teamName = equipoMap[clasif.equipo] ?: "Equipo Desconocido"
                    ClasificacionUi(
                        teamName = teamName,
                        jornadasDisputadas = clasif.jornadasDisputadas ?: 0,
                        points = clasif.points ?: 0
                    )
                }
                _clasificacionUi.value = clasificacionUi
                Log.d("MainViewModel", "Clasificación UI procesada: ${clasificacionUi.size}")
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error al cargar clasificación", e)
            }
        }
    }

    fun getFechas() {
        viewModelScope.launch {
            clearAll()
            try {
                val equipos = RetrofitInstance.api.getEquipos()
                val equipoMap = equipos.associateBy({ it.id }, { it.nombre })
                val fechas = RetrofitInstance.api.getFechas()

                val fechasUi = fechas.mapNotNull { fecha ->
                    val localName = equipoMap[fecha.equipoLocal] ?: "Local Desconocido"
                    val visitanteName = equipoMap[fecha.equipoVisitante] ?: "Visitante Desconocido"
                    FechaUi(
                        jornada = fecha.jornada ?: "N/A",
                        equipoLocal = localName,
                        equipoVisitante = visitanteName,
                        diaAJugar = fecha.diaAJugar ?: "--",
                        horaDePartido = fecha.horaDePartido ?: "--"
                    )
                }
                _fechasUi.value = fechasUi
                Log.d("MainViewModel", "Fechas UI procesadas: ${fechasUi.size}")
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error al cargar fechas", e)
            }
        }
    }
}
