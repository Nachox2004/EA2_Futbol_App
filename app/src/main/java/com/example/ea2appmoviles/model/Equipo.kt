
package com.example.ea2appmoviles.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "equipos")
data class Equipo(
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    val nombre: String,

    @SerializedName("imagen.png")
    val escudo: String?,

    val estadio: String,

    @SerializedName("ano_fundacion")
    val fundacion: Int,

    @SerializedName("division")
    val liga: String
)
