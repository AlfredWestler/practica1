package com.example.rickandmortyalmanaque.presentation.modules

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavigationGraph(
    navController: NavHostController,
//    viewModel: DemoViewModel = hiltViewModel(),
) {
    val onClick: (MainDestinations) -> Unit = {
        navController.navigate(it.name) {
            popUpTo(it.name) { inclusive = true }
        }
    }

    NavHost(navController = navController, startDestination = MainDestinations.ALL_CHARACTERS.name) {
        composable(MainDestinations.ALL_CHARACTERS.name) {
//            DemoDatastore(onClick = onClick, vm = vm)
        }
        composable(MainDestinations.ALL_CHARACTERS.name) {
//            DemoDatastore(onClick = onClick, vm = vm)
        }
    }
}