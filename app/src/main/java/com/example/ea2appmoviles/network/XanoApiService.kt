package com.example.ea2appmoviles.network

import com.example.ea2appmoviles.model.Clasificacion
import com.example.ea2appmoviles.model.Equipo
import com.example.ea2appmoviles.model.Fecha
import retrofit2.http.GET

interface XanoApiService {
    @GET("equipo")
    suspend fun getEquipos(): List<Equipo>

    @GET("clasificacion")
    suspend fun getClasificacion(): List<Clasificacion>

    @GET("fecha")
    suspend fun getFechas(): List<Fecha>
}
