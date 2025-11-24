
package com.example.ea2appmoviles.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ea2appmoviles.viewmodel.EquipoViewModel

@Composable
fun ListaEquiposScreen(
    navController: NavController,
    liga: String, // Se espera el nombre de la liga para mostrar los equipos
    equipoViewModel: EquipoViewModel = viewModel()
) {
    val equipos by equipoViewModel.equipos.collectAsState()

    // Carga los equipos solo cuando la 'liga' cambia
    LaunchedEffect(liga) {
        equipoViewModel.getEquipos(liga)
    }

    Column {
        LazyColumn {
            items(equipos) { equipo ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("detalle_equipo/${equipo.nombre}") } // Ruta corregida
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = equipo.escudo,
                        contentDescription = "Escudo de ${equipo.nombre}",
                        modifier = Modifier.size(40.dp)
                    )
                    Text(
                        text = equipo.nombre,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}
