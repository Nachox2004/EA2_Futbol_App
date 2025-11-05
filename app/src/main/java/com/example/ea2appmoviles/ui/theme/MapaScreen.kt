package com.example.ea2appmoviles.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapaScreen(navController: NavController) {
    val estadios = listOf(
        Stadium("Estadio Nacional Julio Martínez Prádanos", LatLng(-33.465, -70.61)),
        Stadium("Estadio Monumental David Arellano", LatLng(-33.491, -70.607)),
        Stadium("Estadio San Carlos de Apoquindo", LatLng(-33.385, -70.536)),
        Stadium("Estadio Santa Laura-Universidad SEK", LatLng(-33.414, -70.638))
    )

    val santiago = LatLng(-33.45694, -70.64827)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(santiago, 10f)
    }

    Column {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
        GoogleMap(
            modifier = Modifier.weight(1f),
            cameraPositionState = cameraPositionState
        ) {
            estadios.forEach { stadium ->
                Marker(
                    state = MarkerState(position = stadium.location),
                    title = stadium.name
                )
            }
        }
    }
}

data class Stadium(val name: String, val location: LatLng)
