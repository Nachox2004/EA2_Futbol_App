package com.example.ea2appmoviles.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ea2appmoviles.R

// Se añade el logoResId para el recurso del logo
data class TablaPosicionEntry(
    val posicion: Int,
    val nombreEquipo: String,
    val logoResId: Int,
    val pj: Int, // Partidos Jugados
    val g: Int,  // Ganados
    val e: Int,  // Empatados
    val p: Int,  // Perdidos
    val gf: Int, // Goles a Favor
    val gc: Int, // Goles en Contra
    val dif: Int,// Diferencia de Goles
    val pts: Int // Puntos
)

// Función para obtener el logo correspondiente a cada equipo
fun getLogoForTeam(teamName: String): Int {
    return when (teamName) {
        "Audax Italiano" -> R.drawable.audax_italiano
        "Cobresal" -> R.drawable.cobresal
        "Colo-Colo" -> R.drawable.colo_colo
        "Coquimbo Unido" -> R.drawable.coquimbo_unido
        "Deportes Copiapó" -> R.drawable.copiapo
        "Deportes Iquique" -> R.drawable.iquique
        "Deportes La Serena" -> R.drawable.serena
        "Deportes Limache" -> R.drawable.limache
        "Everton" -> R.drawable.everton
        "Huachipato" -> R.drawable.huachipato
        "Ñublense" -> R.drawable.nublense
        "O\'Higgins" -> R.drawable.ohiggins
        "Palestino" -> R.drawable.palestino
        "Unión Española" -> R.drawable.union_espanola
        "Unión La Calera" -> R.drawable.calera
        "Universidad Católica" -> R.drawable.u_catolica
        "Universidad de Chile" -> R.drawable.u_de_chile
        // Para equipos sin logo específico, se usa uno genérico
        else -> R.drawable.futbol_chileno
    }
}


// Nombres de equipos corregidos y con logos asignados
val tablaPrimeraDivision = listOf(
    TablaPosicionEntry(1, "Coquimbo Unido", getLogoForTeam("Coquimbo Unido"), 25, 19, 5, 1, 38, 12, 26, 62),
    TablaPosicionEntry(2, "Universidad Católica", getLogoForTeam("Universidad Católica"), 25, 14, 6, 5, 39, 22, 17, 48),
    TablaPosicionEntry(3, "O\'Higgins", getLogoForTeam("O\'Higgins"), 25, 12, 8, 5, 32, 29, 3, 44),
    TablaPosicionEntry(4, "Audax Italiano", getLogoForTeam("Audax Italiano"), 25, 13, 4, 8, 44, 38, 6, 43),
    TablaPosicionEntry(5, "Universidad de Chile", getLogoForTeam("Universidad de Chile"), 24, 13, 3, 8, 47, 25, 22, 42),
    TablaPosicionEntry(6, "Palestino", getLogoForTeam("Palestino"), 25, 12, 6, 7, 33, 24, 9, 42),
    TablaPosicionEntry(7, "Cobresal", getLogoForTeam("Cobresal"), 25, 12, 5, 8, 31, 28, 3, 41),
    TablaPosicionEntry(8, "Colo-Colo", getLogoForTeam("Colo-Colo"), 25, 9, 8, 8, 38, 29, 9, 35),
    TablaPosicionEntry(9, "Huachipato", getLogoForTeam("Huachipato"), 25, 9, 5, 11, 37, 39, -2, 32),
    TablaPosicionEntry(10, "Ñublense", getLogoForTeam("Ñublense"), 25, 7, 9, 9, 24, 33, -9, 30),
    TablaPosicionEntry(11, "Unión La Calera", getLogoForTeam("Unión La Calera"), 25, 8, 5, 12, 25, 28, -3, 29),
    TablaPosicionEntry(12, "Deportes La Serena", getLogoForTeam("Deportes La Serena"), 25, 6, 6, 13, 29, 44, -15, 24),
    TablaPosicionEntry(13, "Deportes Limache", getLogoForTeam("Deportes Limache"), 25, 5, 7, 13, 29, 37, -8, 22),
    TablaPosicionEntry(14, "Everton", getLogoForTeam("Everton"), 24, 5, 7, 12, 25, 37, -12, 22),
    TablaPosicionEntry(15, "Unión Española", getLogoForTeam("Unión Española"), 25, 6, 2, 17, 28, 47, -19, 20),
    TablaPosicionEntry(16, "Deportes Iquique", getLogoForTeam("Deportes Iquique"), 25, 3, 6, 16, 26, 53, -27, 15)
)

val tablaPrimeraB = listOf(
    TablaPosicionEntry(1, "Deportes Copiapó", getLogoForTeam("Deportes Copiapó"), 29, 14, 10, 5, 38, 17, 21, 52),
    TablaPosicionEntry(2, "Univ. Concepción", getLogoForTeam("Univ. Concepción"), 29, 16, 4, 9, 38, 26, 12, 52),
    TablaPosicionEntry(3, "Cobreloa", getLogoForTeam("Cobreloa"), 29, 13, 8, 8, 42, 42, 0, 47),
    TablaPosicionEntry(4, "San Marcos", getLogoForTeam("San Marcos"), 29, 13, 6, 10, 36, 35, 1, 45),
    TablaPosicionEntry(5, "Rangers de Talca", getLogoForTeam("Rangers de Talca"), 29, 10, 13, 6, 35, 32, 3, 43),
    TablaPosicionEntry(6, "Santiago Wanderers", getLogoForTeam("Santiago Wanderers"), 29, 10, 11, 8, 40, 35, 5, 41),
    TablaPosicionEntry(7, "Antofagasta", getLogoForTeam("Antofagasta"), 29, 10, 10, 9, 41, 32, 9, 40),
    TablaPosicionEntry(8, "Concepción", getLogoForTeam("Concepción"), 29, 11, 7, 11, 40, 37, 3, 40),
    TablaPosicionEntry(9, "San Luis de Quillota", getLogoForTeam("San Luis de Quillota"), 29, 9, 12, 8, 30, 32, -2, 39),
    TablaPosicionEntry(10, "Deportes Recoleta", getLogoForTeam("Deportes Recoleta"), 29, 8, 11, 10, 28, 34, -6, 35),
    TablaPosicionEntry(11, "Magallanes", getLogoForTeam("Magallanes"), 29, 8, 8, 13, 26, 32, -6, 32),
    TablaPosicionEntry(12, "Curicó Unido", getLogoForTeam("Curicó Unido"), 29, 7, 10, 12, 32, 37, -5, 31),
    TablaPosicionEntry(13, "Santa Cruz", getLogoForTeam("Santa Cruz"), 29, 7, 10, 12, 29, 37, -8, 31),
    TablaPosicionEntry(14, "Unión San Felipe", getLogoForTeam("Unión San Felipe"), 29, 8, 6, 15, 29, 36, -7, 30),
    TablaPosicionEntry(15, "Deportes Temuco", getLogoForTeam("Deportes Temuco"), 29, 6, 12, 11, 31, 39, -8, 30),
    TablaPosicionEntry(16, "Santiago Morning", getLogoForTeam("Santiago Morning"), 29, 9, 8, 12, 24, 36, -12, 26)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TablaPosicionesScreen(navController: NavController, liga: String) {
    val tabla = if (liga == "Primera División") tablaPrimeraDivision else tablaPrimeraB

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tabla de Posiciones - $liga") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Cabecera de la tabla
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .padding(vertical = 8.dp, horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("#", modifier = Modifier.weight(0.5f), fontWeight = FontWeight.Bold, fontSize = 12.sp, textAlign = TextAlign.Center)
                Text("Equipo", modifier = Modifier.weight(2.5f), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text("PJ", modifier = Modifier.weight(0.7f), fontWeight = FontWeight.Bold, fontSize = 12.sp, textAlign = TextAlign.Center)
                Text("G", modifier = Modifier.weight(0.5f), fontWeight = FontWeight.Bold, fontSize = 12.sp, textAlign = TextAlign.Center)
                Text("E", modifier = Modifier.weight(0.5f), fontWeight = FontWeight.Bold, fontSize = 12.sp, textAlign = TextAlign.Center)
                Text("P", modifier = Modifier.weight(0.5f), fontWeight = FontWeight.Bold, fontSize = 12.sp, textAlign = TextAlign.Center)
                Text("DG", modifier = Modifier.weight(0.7f), fontWeight = FontWeight.Bold, fontSize = 12.sp, textAlign = TextAlign.Center)
                Text("Pts", modifier = Modifier.weight(0.8f), fontWeight = FontWeight.Bold, fontSize = 12.sp, textAlign = TextAlign.Center)
            }

            // Contenido de la tabla
            LazyColumn(modifier = Modifier.weight(1f)) {
                itemsIndexed(tabla) { index, item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(if (index % 2 == 0) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceVariant)
                            .clickable { navController.navigate("detalle_equipo/${item.nombreEquipo}") }
                            .padding(vertical = 4.dp, horizontal = 4.dp), // Padding reducido para que quepa mejor
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(item.posicion.toString(), modifier = Modifier.weight(0.5f), fontSize = 12.sp, textAlign = TextAlign.Center)
                        
                        // Celda de Equipo con Logo y Nombre
                        Row(
                            modifier = Modifier.weight(2.5f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = item.logoResId),
                                contentDescription = "Logo de ${item.nombreEquipo}",
                                modifier = Modifier.size(20.dp) // Tamaño del logo
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(item.nombreEquipo, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        }
                        
                        Text(item.pj.toString(), modifier = Modifier.weight(0.7f), fontSize = 12.sp, textAlign = TextAlign.Center)
                        Text(item.g.toString(), modifier = Modifier.weight(0.5f), fontSize = 12.sp, textAlign = TextAlign.Center)
                        Text(item.e.toString(), modifier = Modifier.weight(0.5f), fontSize = 12.sp, textAlign = TextAlign.Center)
                        Text(item.p.toString(), modifier = Modifier.weight(0.5f), fontSize = 12.sp, textAlign = TextAlign.Center)
                        Text(item.dif.toString(), modifier = Modifier.weight(0.7f), fontSize = 12.sp, textAlign = TextAlign.Center)
                        Text(item.pts.toString(), modifier = Modifier.weight(0.8f), fontSize = 12.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
                    }
                }
            }

            // Botón para ver la última fecha
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("fecha/$liga") },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Ver Última Fecha")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
