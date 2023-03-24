package com.example.rickandmortyalmanaque

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyalmanaque.presentation.modules.MainNavigationGraph
import com.example.rickandmortyalmanaque.presentation.ui.theme.RickAndMortyAlmanaqueTheme
import com.example.rickandmortyalmanaque.ui.MortyModel

class MainActivity : ComponentActivity() {

    private val vm: MortyModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            RickAndMortyAlmanaqueTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainNavigationGraph(navController = navController, vm)
                }
            }
        }
    }
}