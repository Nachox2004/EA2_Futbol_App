package com.example.ea2appmoviles.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Fecha(
    @PrimaryKey val id: Int,
    @SerializedName("equipo_local")
    val equipoLocal: Int? = null,
    @SerializedName("equipo_visitante")
    val equipoVisitante: Int? = null,
    @SerializedName("dia_a_jugar")
    val diaAJugar: String? = null, // Se usa String para el tipo 'date' de Xano
    @SerializedName("hora_de_partido")
    val horaDePartido: String? = null,
    val jornada: String? = null
)
