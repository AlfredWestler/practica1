package com.example.rickandmortyalmanaque.presentation.modules

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickandmortyalmanaque.CharacterItem
import com.example.rickandmortyalmanaque.presentation.ui.components.CharactersScreen

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
            CharactersScreen(){
                onClick(MainDestinations.CHARACTER_DETAIL)
            }
        }
        composable(MainDestinations.CHARACTER_DETAIL.name) {
//            DemoDatastore(onClick = onClick, vm = vm)
        }
    }
}