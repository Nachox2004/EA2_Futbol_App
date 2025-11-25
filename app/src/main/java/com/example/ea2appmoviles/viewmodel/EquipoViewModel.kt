
package com.example.ea2appmoviles.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ea2appmoviles.model.Equipo
import com.example.ea2appmoviles.repository.EquipoRepository
import com.example.ea2appmoviles.repository.JugadorRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EquipoViewModel(
    private val equipoRepository: EquipoRepository,
    private val jugadorRepository: JugadorRepository
) : ViewModel() {

    private val _equipos = MutableStateFlow<List<Equipo>>(emptyList())
    val equipos: StateFlow<List<Equipo>> = _equipos

    private val _equipoSeleccionado = MutableStateFlow<Equipo?>(null)
    val equipoSeleccionado: StateFlow<Equipo?> = _equipoSeleccionado

    private var getEquiposJob: Job? = null

    fun getEquipos(liga: String) {
        getEquiposJob?.cancel()

        getEquiposJob = viewModelScope.launch {
            try {
                Log.d("EquipoViewModel", "Iniciando carga de equipos para liga: '$liga'")
                val equiposCargados = if (liga == "XANO_TODOS") {
                    equipoRepository.getAllFromApi()
                } else {
                    equipoRepository.getByLiga(liga)
                }
                _equipos.value = equiposCargados
                Log.d("EquipoViewModel", "Carga de equipos completada. Se encontraron ${equiposCargados.size} equipos.")
            } catch (e: Exception) {
                Log.e("EquipoViewModel", "Error en el ViewModel al cargar equipos: ${e.message}", e)
                _equipos.value = emptyList() // Asegura que la lista esté vacía en caso de error
            }
        }
    }

    fun buscarEquipoPorNombre(nombre: String) {
        viewModelScope.launch {
            _equipoSeleccionado.value = equipoRepository.getByName(nombre)
        }
    }
}

