package com.example.ea2appmoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ea2appmoviles.model.ClasificacionUi
import com.example.ea2appmoviles.model.Equipo
import com.example.ea2appmoviles.model.FechaUi
import com.example.ea2appmoviles.ui.theme.EA2AppMovilesTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EA2AppMovilesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().background(Color(0xFFF5F5F5))
                ) {
                    HomeScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(viewModel: MainViewModel) {
    val equipos by viewModel.equipos.collectAsState()
    val clasificacionUi by viewModel.clasificacionUi.collectAsState()
    val fechasUi by viewModel.fechasUi.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Futbolito",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { viewModel.getEquipos() }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B5E20))) {
                Text("Equipos", color = Color.White)
            }
            Button(onClick = { viewModel.getClasificacion() }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B5E20))) {
                Text("Clasificación", color = Color.White)
            }
            Button(onClick = { viewModel.getFechas() }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B5E20))) {
                Text("Fechas", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            if (equipos.isNotEmpty()) {
                item { SectionTitle("Equipos") }
                items(equipos) { equipo -> EquipoItem(equipo) }
            }
            if (clasificacionUi.isNotEmpty()) {
                item { SectionTitle("Clasificación") }
                items(clasificacionUi) { clasif -> ClasificacionItem(clasif) }
            }
            if (fechasUi.isNotEmpty()) {
                item { SectionTitle("Fechas") }
                items(fechasUi) { fecha -> FechaItem(fecha) }
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black, modifier = Modifier.padding(top = 16.dp, bottom = 8.dp))
}

@Composable
fun ItemCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Box(modifier = Modifier.padding(12.dp)) {
            content()
        }
    }
}

@Composable
fun EquipoItem(equipo: Equipo) {
    ItemCard {
        Column {
            Text(equipo.nombre, fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 16.sp)
            Text("Estadio: ${equipo.estadio ?: "No disponible"}", color = Color.DarkGray)
            Text("Fundación: ${equipo.fundacion ?: "No disponible"}", color = Color.DarkGray)
        }
    }
}

@Composable
fun ClasificacionItem(clasif: ClasificacionUi) {
    ItemCard {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(clasif.teamName, fontWeight = FontWeight.Bold, color = Color.Black, modifier = Modifier.weight(1f))
            Text("J: ${clasif.jornadasDisputadas}", color = Color.DarkGray, modifier = Modifier.padding(horizontal = 8.dp))
            Text("Pts: ${clasif.points}", fontWeight = FontWeight.Bold, color = Color.Black)
        }
    }
}

@Composable
fun FechaItem(fecha: FechaUi) {
    ItemCard {
        Column {
            Text("Jornada: ${fecha.jornada}", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 16.sp)
            Text("${fecha.equipoLocal} vs ${fecha.equipoVisitante}", color = Color.DarkGray)
            Text("Fecha: ${fecha.diaAJugar} - Hora: ${fecha.horaDePartido}", color = Color.DarkGray)
        }
    }
}
