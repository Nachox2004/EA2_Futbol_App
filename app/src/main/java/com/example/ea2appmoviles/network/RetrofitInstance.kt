
package com.example.ea2appmoviles.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    // Reemplaza "api:TU_GRUPO_API/" con la URL de tu grupo de API de Xano.
    // La encontrarás en la sección "API" de tu proyecto en Xano.
    private const val BASE_URL = "https://x8ki-letl-twmt.n7.xano.io/api:TU_GRUPO_API/"

    val api: XanoApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(XanoApiService::class.java)
    }
}
