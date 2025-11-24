package com.example.ea2appmoviles.remote

import com.example.ea2appmoviles.model.Equipo
import retrofit2.http.GET

interface ApiService {
    @GET("equipos")
    suspend fun getEquipos(): List<Equipo>
}
