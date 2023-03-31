package com.example.rickandmortyalmanaque.presentation.ui.components

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.example.rickandmortyalmanaque.MainActivity
import com.example.rickandmortyalmanaque.R
import com.example.rickandmortyalmanaque.presentation.ui.components.pager.Pager

@Composable
fun OnBoardingScreen(){
    val context = LocalContext.current
    val items = listOf(
        PagerItem(0, "Adentrate en el universo de Rick & Morty", R.raw.red_portal),
        PagerItem(1, "Consulta toda la información de tus personajes favoritos", R.raw.morty_cry_loader),
        PagerItem(2, "Diviertete", R.raw.morty_dance_loader),
    )
    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        Box(
            Modifier
                .fillMaxSize()
                .background(color = Color.Black.copy(alpha = 0.4f)),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Pager(
                    items = items,
                    modifier = Modifier
                        .fillMaxSize(),
                    itemFraction = .75f,
                    overshootFraction = .75f,
                    initialIndex = 0,
                    itemSpacing = 100.dp,
                    contentFactory = { item ->
                        PagerPage(items, item, context)
                    }
                )
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}

@Composable
private fun PagerPage(items: List<PagerItem>, item: PagerItem, context: Context) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(item.lottie)
    )
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true,
        speed = 1F,
        restartOnPlay = false
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LottieAnimation(
            composition,
            progress,
            modifier = Modifier.size(400.dp)
        )
        Text(
            text = item.description,
            style = TextStyle(
                color = Color.Green,
                fontSize = 16.sp,
                fontFamily = FontFamily.Monospace,
                letterSpacing = 2.sp,
                textAlign = TextAlign.Center,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(8f, 8f),
                    blurRadius = 4f
                ),
                textGeometricTransform = TextGeometricTransform(
                    scaleX = 1.5f,
                    skewX = 0.5f
                )
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            items.forEachIndexed { i, _ ->
                Box(
                    modifier = Modifier
                        .height(8.dp)
                        .width(8.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(color = if (i == item.position) Color.Magenta else Color.LightGray)
                        .padding(end = 4.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
        if ((item.position+1) == items.size){
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = {
                context.startActivity(Intent(context, MainActivity::class.java))
                (context as Activity).finish()
            }) {
                Text(
                    text = "Comencemos",
                    style = TextStyle(
                        color = Color.Green,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = 2.sp,
                        textAlign = TextAlign.Center,
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(8f, 8f),
                            blurRadius = 4f
                        ),
                        textGeometricTransform = TextGeometricTransform(
                            scaleX = 1.5f,
                            skewX = -0.5f
                        )
                    )
                )
            }
        }
    }
}

data class PagerItem(
    val position: Int,
    val description: String,
    val lottie: Int
)