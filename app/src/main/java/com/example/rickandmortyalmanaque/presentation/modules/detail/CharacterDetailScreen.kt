package com.example.rickandmortyalmanaque.presentation.modules.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.rickandmortyalmanaque.presentation.modules.MainDestinations
import com.example.rickandmortyalmanaque.presentation.ui.components.shimmer.GSBCShimmerAnimation
import com.example.rickandmortyalmanaque.presentation.ui.components.toolbar.GSBCToolBar
import com.example.rickandmortyalmanaque.presentation.ui.components.toolbar.GSBCToolBarButtons
import com.skydoves.landscapist.glide.GlideImage
import com.example.rickandmortyalmanaque.R
import com.example.rickandmortyalmanaque.ui.MortyModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CharacterDetailScreen(
    onClick: (MainDestinations) -> Unit,
    viewModel: MortyModel
) {

    Scaffold(
        topBar = {
            GSBCToolBar(
                title = "Character detail",
                leftButton = GSBCToolBarButtons(
                    image = R.drawable.ic_baseline_arrow_back_24,
                    color = Color.Black,
                ),
                leftButtonListener = { onClick(MainDestinations.ALL_CHARACTERS) }
            )
        }
    ) {
        Column(Modifier.fillMaxSize()) {
            GlideImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(horizontal = 20.dp)
                    .padding(top = 30.dp),
                imageModel = viewModel.selected.value?.image,
                contentScale = ContentScale.FillWidth,
                failure = {
                    Box(Modifier.fillMaxSize().background(Color.Red))
                },
                loading = {
                    GSBCShimmerAnimation() {
                        Box(Modifier.fillMaxSize().background(it))
                    }
                }
            )
            Text(
                modifier = Modifier.padding(top = 10.dp, start = 20.dp),
                text = viewModel.selected.value?.name.orEmpty()
            )
            Text(
                modifier = Modifier.padding(top = 10.dp, start = 20.dp),
                text = viewModel.selected.value?.status.orEmpty()
            )
            Text(
                modifier = Modifier.padding(top = 10.dp, start = 20.dp),
                text = viewModel.selected.value?.species.orEmpty()
            )
            Text(
                modifier = Modifier.padding(top = 10.dp, start = 20.dp),
                text = viewModel.selected.value?.gender.orEmpty()
            )
        }
    }
}