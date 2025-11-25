
package com.example.ea2appmoviles.repository

import android.util.Log
import com.example.ea2appmoviles.model.Equipo
import com.example.ea2appmoviles.network.RetrofitInstance

class EquipoRepository() {

    private val apiService = RetrofitInstance.api

    private suspend fun fetchAndLogEquipos(): List<Equipo> {
        return try {
            val equipos = apiService.getEquipos()
            Log.d("EquipoRepository", "Datos recibidos de la API: ${equipos.size} equipos.")
            equipos
        } catch (e: Exception) {
            Log.e("EquipoRepository", "Error al obtener datos de la API: ${e.message}", e)
            emptyList() // Devuelve una lista vacía en caso de error
        }
    }

    suspend fun getAllFromApi(): List<Equipo> {
        return fetchAndLogEquipos()
    }

    suspend fun getByLiga(liga: String): List<Equipo> {
        val todosLosEquipos = fetchAndLogEquipos()
        return todosLosEquipos.filter { it.liga == liga }
    }

    suspend fun getById(id: Int): Equipo? {
        val todosLosEquipos = fetchAndLogEquipos()
        return todosLosEquipos.find { it.id == id }
    }

    suspend fun getByName(nombre: String): Equipo? {
        val todosLosEquipos = fetchAndLogEquipos()
        return todosLosEquipos.find { it.nombre == nombre }
    }
}
