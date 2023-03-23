package com.example.rickandmortyalmanaque.presentation.ui.components.toolbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.Visibility
import com.example.rickandmortyalmanaque.presentation.ui.components.shimmer.GSBCShimmerAnimation

@Composable
fun GSBCToolBar(
    title: String,
    titleColor: Color = Color.Black,
    backgroundColor: GSBCToolbarBackground = GSBCToolbarBackground.Single(Color.White),
    activateShimmer: Boolean = false,
    leftButton: GSBCToolBarButtons? = null,
    rightButton: GSBCToolBarButtons? = null,
    secondaryButton: GSBCToolBarButtons? = null,
    leftButtonListener: (() -> Unit)? = null,
    rightButtonListener: (() -> Unit)? = null,
    secondaryButtonListener: (() -> Unit)? = null,
    progressBar: GSBCProgressIndicator? = null,
    textLeftAlignment: Boolean = false
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    brush = when (backgroundColor) {
                        is GSBCToolbarBackground.Gradient -> {
                            Brush.horizontalGradient(
                                colors = listOf(
                                    backgroundColor.start,
                                    backgroundColor.end
                                )
                            )
                        }
                        is GSBCToolbarBackground.Single -> {
                            Brush.horizontalGradient(
                                colors = listOf(
                                    backgroundColor.color,
                                    backgroundColor.color
                                )
                            )
                        }
                    }
                )
        ){
            val leftImageId = "leftImageToolbar"
            val rightImageId = "rightImageToolbar"
            val secondaryImageId = "secondaryImageToolbar"
            val titleTextId = "titleTextToolbar"
            val toolbarConstraints = ConstraintSet {
                val titleText = createRefFor(titleTextId)
                val secondaryImage = createRefFor(secondaryImageId)
                val rightImage = createRefFor(rightImageId)
                val leftImage = createRefFor(leftImageId)
                constrain(titleText) {
                    linkTo(parent.top, parent.bottom)
                    linkTo(parent.start, parent.end, startMargin = 48.dp, endMargin = 48.dp)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }
                constrain(leftImage) {
                    linkTo(parent.top, parent.bottom)
                    start.linkTo(parent.start, margin = 16.dp)
                    width = Dimension.value(24.dp)
                    height = Dimension.value(24.dp)
                    visibility = if(leftButton != null) Visibility.Visible else Visibility.Invisible
                }
                constrain(rightImage) {
                    linkTo(parent.top, parent.bottom)
                    end.linkTo(parent.end, margin = 16.dp)
                    width = Dimension.value(24.dp)
                    height = Dimension.value(24.dp)
                    visibility = if(rightButton != null) Visibility.Visible else Visibility.Invisible
                }
                constrain(secondaryImage) {
                    linkTo(parent.top, parent.bottom)
                    end.linkTo(rightImage.start, margin = 4.dp)
                    width = Dimension.value(24.dp)
                    height = Dimension.value(24.dp)
                    visibility = if(secondaryButton != null) Visibility.Visible else Visibility.Invisible
                }
            }
            ConstraintLayout(toolbarConstraints, modifier = Modifier.fillMaxSize()) {
                leftButton?.let {
                    if(activateShimmer && it.enableShimmer){
                        GSBCShimmerAnimation { brush ->
                            Icon(
                                modifier = Modifier
                                    .layoutId(leftImageId)
                                    .graphicsLayer(alpha = 0.99f)
                                    .drawWithCache {
                                        onDrawWithContent {
                                            drawContent()
                                            drawRect(brush, blendMode = BlendMode.SrcAtop)
                                        }
                                    },
                                painter = painterResource(id = it.image),
                                contentDescription = "",
                            )
                        }
                    } else {

                        Icon(
                            modifier = Modifier
                                .layoutId(leftImageId)
                                .clickable { leftButtonListener?.invoke() },
                            painter = painterResource(id = it.image),
                            tint = it.color,
                            contentDescription = ""
                        )
                    }
                }
                rightButton?.let {
                    if(activateShimmer && it.enableShimmer){
                        GSBCShimmerAnimation { brush ->
                            Icon(
                                modifier = Modifier
                                    .layoutId(rightImageId)
                                    .graphicsLayer(alpha = 0.99f)
                                    .drawWithCache {
                                        onDrawWithContent {
                                            drawContent()
                                            drawRect(brush, blendMode = BlendMode.SrcAtop)
                                        }
                                    },
                                painter = painterResource(id = it.image),
                                contentDescription = "",
                            )
                        }
                    } else {
                        Icon(
                            modifier = Modifier
                                .layoutId(rightImageId)
                                .clickable { rightButtonListener?.invoke() },
                            painter = painterResource(id = it.image),
                            tint = it.color,
                            contentDescription = ""
                        )
                    }
                }
                secondaryButton?.let {
                    if(activateShimmer && it.enableShimmer){
                        GSBCShimmerAnimation { brush ->
                            Icon(
                                modifier = Modifier
                                    .layoutId(secondaryImageId)
                                    .graphicsLayer(alpha = 0.99f)
                                    .drawWithCache {
                                        onDrawWithContent {
                                            drawContent()
                                            drawRect(brush, blendMode = BlendMode.SrcAtop)
                                        }
                                    },
                                painter = painterResource(id = it.image),
                                contentDescription = "",
                            )
                        }
                    } else {
                        Icon(
                            modifier = Modifier
                                .layoutId(secondaryImageId)
                                .clickable { secondaryButtonListener?.invoke() },
                            painter = painterResource(id = it.image),
                            tint = it.color,
                            contentDescription = ""
                        )
                    }
                }
                Text(
                    modifier = Modifier.layoutId(titleTextId),
                    text = title,
                    textAlign = if(textLeftAlignment) TextAlign.Start else TextAlign.Center,
                    color = titleColor,
                    fontSize = 14.sp,
//                    fontFamily= poppinsFamily,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        if(progressBar != null){
            val progress = (1.0 / progressBar.totalSteps).toFloat()
            val lastStepPercent = ((((progressBar.currentStep - 1)*100.0)/progressBar.totalSteps)/100.0).toFloat()
            val progressValue = remember { mutableStateOf(0f) }
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(
                progress = (progress*progressBar.currentStep),
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp)),
                color = progressBar.fillColor,
                backgroundColor = progressBar.backgroundColor
            )
        }
    }

}

data class GSBCToolBarButtons(
    val image: Int,
    val color: Color,
    val enableShimmer: Boolean = false
)

data class GSBCProgressIndicator(
    val currentStep: Int,
    val totalSteps: Int,
    val fillColor: Color,
    val backgroundColor: Color
)

sealed class GSBCToolbarImage {
    class DrawableResource(@DrawableRes image: Int)
    class IconsImageVector(image: ImageVector)
}

sealed class GSBCToolbarBackground{
    class Gradient(val start: Color, val end: Color): GSBCToolbarBackground()
    class Single(val color: Color): GSBCToolbarBackground()
}
