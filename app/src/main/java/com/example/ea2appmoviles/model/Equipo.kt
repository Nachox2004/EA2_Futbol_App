package com.example.ea2appmoviles.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "equipos")
data class Equipo(
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,

    var nombre: String = "",

    var estadio: String = "",

    @SerializedName("ano_fundacion")
    var fundacion: Int = 0,

    @SerializedName("division")
    var liga: String = "",

    // Simplificado para manejar la URL del escudo directamente
    var escudo: String? = null
)
