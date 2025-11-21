
package com.example.ea2appmoviles.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ea2appmoviles.viewmodel.EquipoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EquipoDetailScreen(
    navController: NavController,
    nombreEquipo: String, // Se espera el nombre del equipo para buscarlo
    equipoViewModel: EquipoViewModel = viewModel()
) {
    // Busca el equipo por su nombre
    equipoViewModel.buscarEquipoPorNombre(nombreEquipo)

    val equipo by equipoViewModel.equipoSeleccionado.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(equipo?.nombre ?: "Detalles del Equipo") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            equipo?.let {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        AsyncImage(
                            model = it.escudo,
                            contentDescription = "Escudo de ${it.nombre}",
                            modifier = Modifier.size(120.dp)
                        )
                        Text(
                            text = it.nombre,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = "Estadio: ${it.estadio}", fontSize = 18.sp)
                        Text(text = "Fundado en: ${it.fundacion}", fontSize = 16.sp)
                    }
                }
            } ?: run {
                // Muestra un indicador de carga mientras se obtienen los datos
                CircularProgressIndicator()
            }
        }
    }
}
