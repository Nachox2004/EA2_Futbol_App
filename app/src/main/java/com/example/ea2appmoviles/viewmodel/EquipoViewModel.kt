
package com.example.ea2appmoviles.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ea2appmoviles.model.Equipo
import com.example.ea2appmoviles.repository.EquipoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EquipoViewModel() : ViewModel() {

    private val equipoRepository: EquipoRepository = EquipoRepository()

    private val _equipos = MutableStateFlow<List<Equipo>>(emptyList())
    val equipos: StateFlow<List<Equipo>> = _equipos

    private val _equipoSeleccionado = MutableStateFlow<Equipo?>(null)
    val equipoSeleccionado: StateFlow<Equipo?> = _equipoSeleccionado

    fun getEquipos(liga: String) {
        viewModelScope.launch {
            _equipos.value = equipoRepository.getByLiga(liga)
        }
    }

    fun buscarEquipoPorNombre(nombre: String) {
        viewModelScope.launch {
            _equipoSeleccionado.value = equipoRepository.getByName(nombre)
        }
    }
}

