package com.example.ea2appmoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ea2appmoviles.database.AppDatabase
import com.example.ea2appmoviles.repository.EquipoRepository
import com.example.ea2appmoviles.repository.JugadorRepository
import com.example.ea2appmoviles.ui.theme.*
import com.example.ea2appmoviles.viewmodel.EquipoViewModel
import com.example.ea2appmoviles.viewmodel.EquipoViewModelFactory

class MainActivity : ComponentActivity() {

    private val database by lazy { AppDatabase.getInstance(this) }
    private val equipoRepository by lazy { EquipoRepository() }
    private val jugadorRepository by lazy { JugadorRepository(database.jugadorDao()) }
    private val viewModelFactory by lazy { EquipoViewModelFactory(equipoRepository, jugadorRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EA2AppMovilesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: EquipoViewModel = viewModel(factory = viewModelFactory)
                    AppNavigation(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun AppNavigation(viewModel: EquipoViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            Inicio(navController = navController)
        }

        composable("noticias") {
            NoticiasScreen(navController = navController)
        }

        composable("tabla_posiciones/{liga}") { backStackEntry ->
            val liga = backStackEntry.arguments?.getString("liga") ?: ""
            TablaPosicionesScreen(navController = navController, liga = liga)
        }

        composable("fecha/{liga}") { backStackEntry ->
            val liga = backStackEntry.arguments?.getString("liga") ?: ""
            FechaScreen(navController = navController, liga = liga)
        }

        composable("detalle_equipo/{equipoNombre}") { backStackEntry ->
            val equipoNombre = backStackEntry.arguments?.getString("equipoNombre") ?: ""
            LaunchedEffect(equipoNombre) {
                viewModel.buscarEquipoPorNombre(equipoNombre)
            }
            val equipo by viewModel.equipoSeleccionado.collectAsState()
            equipo?.let {
                EquipoDetailScreen(navController = navController, equipo = it)
            }
        }
    }
}
