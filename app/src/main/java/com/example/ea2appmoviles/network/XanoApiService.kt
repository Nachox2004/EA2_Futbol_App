
package com.example.ea2appmoviles.network

import com.example.ea2appmoviles.model.Equipo
import retrofit2.http.GET

interface XanoApiService {
    // Volvemos a "equipos" (plural), que es como Xano suele crear los endpoints por defecto,
    // aunque la tabla se llame "equipo".
    @GET("equipos")
    suspend fun getEquipos(): List<Equipo>
}
