package com.example.ea2appmoviles.ui.theme

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ea2appmoviles.R

@Composable
fun Inicio(navController: NavController) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.futbol_chileno),
            contentDescription = "Fondo de Fútbol",
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.1f), // Fondo con transparencia
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Futbolito Chile",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { navController.navigate("tabla_posiciones/Primera División") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Primera División", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("tabla_posiciones/Primera B") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Primera B", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("noticias") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Noticias", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val gmmIntentUri = Uri.parse("geo:0,0?q=estadios de futbol en chile")
                    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                    mapIntent.setPackage("com.google.android.apps.maps")
                    context.startActivity(mapIntent)
                 },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Maps", fontSize = 16.sp)
            }
        }
    }
}
