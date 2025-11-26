package com.example.ea2appmoviles.repository

import com.example.ea2appmoviles.model.Clasificacion
import com.example.ea2appmoviles.network.RetrofitInstance

class TablaPosicionesRepository() {
    private val apiService = RetrofitInstance.api

    suspend fun getAll(): List<Clasificacion> {
        return try {
            apiService.getClasificacion()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
