package com.example.rickandmortyalmanaque.presentation.ui.components

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.rickandmortyalmanaque.CharacterItem
import com.example.rickandmortyalmanaque.ui.MortyModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CharactersScreen(
    navigateToDetail: (character: String)-> Unit,
    viewModel: MortyModel
){
    val context = LocalContext.current
    val listCharacters = listOf("1","2","3")
    Scaffold (
        content = { paddingValues ->
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                viewModel.data.value.forEach {character ->
                    CharacterItem(urlImage = character.image, characterName = character.name){
                        viewModel.setCharacter(character)
                        Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    )
}