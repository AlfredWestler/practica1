package com.example.rickandmortyalmanaque

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.rickandmortyalmanaque.presentation.ui.components.OnBoardingScreen

class OnBoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnBoardingScreen()
        }
    }
}