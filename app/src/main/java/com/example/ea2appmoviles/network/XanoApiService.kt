
package com.example.ea2appmoviles.network

import com.example.ea2appmoviles.model.Equipo
import retrofit2.http.GET

interface XanoApiService {
    @GET("equipo")
    suspend fun getEquipos(): List<Equipo>
}
