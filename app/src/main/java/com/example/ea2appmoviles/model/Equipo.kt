
package com.example.ea2appmoviles.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class EscudoImage(
    val url: String? = null
)

@Entity(tableName = "equipos")
data class Equipo(
    // Las propiedades se cambian a 'var' y se les da un valor por defecto
    // para resolver el conflicto entre Room y GSON.
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,

    var nombre: String = "",

    var estadio: String = "",

    @SerializedName("ano_fundacion")
    var fundacion: Int = 0,

    @SerializedName("division")
    var liga: String = "",

    @SerializedName("escudo")
    @Ignore
    var escudoObject: EscudoImage? = null
) {
    val escudo: String?
        get() = escudoObject?.url
}
