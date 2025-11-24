
package com.example.ea2appmoviles.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ea2appmoviles.model.Equipo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EquipoDetailScreen(
    navController: NavController,
    equipo: Equipo? // Recibe el objeto Equipo, que puede ser nulo mientras carga
) {
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
            equipo?.let { // Si el equipo no es nulo, muestra los detalles
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
                // Si el equipo es nulo (cargando), muestra un indicador de progreso
                CircularProgressIndicator()
            }
        }
    }
}
