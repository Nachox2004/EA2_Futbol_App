
package com.example.ea2appmoviles.repository

import com.example.ea2appmoviles.model.Equipo
import com.example.ea2appmoviles.network.RetrofitInstance

class EquipoRepository() {

    private val apiService = RetrofitInstance.api

    suspend fun getAll(): List<Equipo> {
        // Llama a la API para obtener todos los equipos
        return apiService.getEquipos()
    }

    suspend fun getByLiga(liga: String): List<Equipo> {
        // Obtiene todos los equipos y los filtra por liga
        return apiService.getEquipos().filter { it.liga == liga }
    }

    suspend fun getById(id: Int): Equipo? {
        // Obtiene todos los equipos y busca el que coincida con el ID
        return apiService.getEquipos().find { it.id == id }
    }

    suspend fun getByName(nombre: String): Equipo? {
        // Obtiene todos los equipos y busca el que coincida con el nombre
        return apiService.getEquipos().find { it.nombre == nombre }
    }

    // El método insert se elimina ya que los datos ahora provienen de una API externa
}
