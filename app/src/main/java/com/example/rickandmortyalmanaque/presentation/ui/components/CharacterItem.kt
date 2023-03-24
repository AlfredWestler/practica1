package com.example.rickandmortyalmanaque

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterItem(
    urlImage: String,
    characterName: String,
    onClickItem: (character: String)->Unit
){
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .background(Color.Gray)
            .clickable {
                onClickItem(characterName)
            }
    ) {
        GlideImage(
            imageModel = urlImage,
            failure = {
                Image(
                    painter = painterResource(id =R.drawable.rick_loader),
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        )

        Text(
            text = characterName,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp)
                .background(Color.White)
                .clip(CircleShape)
        )
    }
}