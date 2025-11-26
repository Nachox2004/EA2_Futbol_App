package com.example.ea2appmoviles.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Clasificacion(
    @PrimaryKey val id: Int,
    val equipo: Int? = null, // Asumiendo que es el ID del equipo
    @SerializedName("jornadas_disputadas")
    val jornadasDisputadas: Int? = null,
    @SerializedName("puntos")
    val points: Int? = null
)
