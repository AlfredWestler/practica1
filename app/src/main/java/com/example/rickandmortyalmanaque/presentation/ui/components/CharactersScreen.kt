package com.example.rickandmortyalmanaque.presentation.ui.components

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.rickandmortyalmanaque.CharacterItem
import com.example.rickandmortyalmanaque.presentation.ui.components.shimmer.GSBCShimmerAnimation
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
            LazyColumn(
                Modifier.fillMaxSize(),
                state = rememberLazyListState()
            ) {
                if(viewModel.data.value.isEmpty()) {
                    items(10) {
                        GSBCShimmerAnimation() {
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .padding(horizontal = 20.dp, vertical = 5.dp)
                                    .background(it)
                            )
                        }
                    }
                } else {
                    items(viewModel.data.value) {character ->
                        CharacterItem(urlImage = character.image, characterName = character.name){
                            viewModel.setCharacter(character)
                            navigateToDetail(it)
                            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    )
}