
package com.example.ea2appmoviles.model

// He eliminado las anotaciones de Room y he cambiado el tipo de `escudo` a String.
// Esto es para que coincida con la estructura de datos que probablemente obtendrás de tu API de Xano,
// donde el escudo será una URL a una imagen.
data class Equipo(
    val id: Int = 0,
    val nombre: String,
    val escudo: String,
    val estadio: String,
    val fundacion: String,
    val liga: String
)
