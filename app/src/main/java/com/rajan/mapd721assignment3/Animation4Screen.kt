package com.rajan.mapd721assignment3

import androidx.compose.foundation.background
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.animation.core.*
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


@Composable
fun Animation4Screen() {
    val offset = remember { Animatable(Offset(0f, 0f), Offset.VectorConverter) }
    val scale = remember { Animatable(1f) }
    val infiniteTransition = rememberInfiniteTransition()

    // Animated gradient colors
    val gradientColors = listOf(
        Color(0xFF6A1B9A),  // Purple
        Color(0xFF9C27B0),  // Light Purple
        Color(0xFFE040FB),  // Pink
        Color(0xFF7C4DFF)   // Periwinkle
    )

    // Animated background transition
    val animatedOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = gradientColors,
                    start = Offset(animatedOffset, 0f),
                    end = Offset(animatedOffset + 1000f, 1000f)
                )
            )
            .pointerInput(Unit) {
                coroutineScope {
                    while (true) {
                        val position = awaitPointerEventScope {
                            awaitFirstDown().position
                        }
                        launch {
                            // Bounce animation sequence
                            scale.animateTo(0.8f, animationSpec = spring(0.5f))
                            offset.animateTo(
                                position,
                                animationSpec = spring(
                                    dampingRatio = 0.4f,
                                    stiffness = 200f
                                )
                            )
                            scale.animateTo(1f, animationSpec = spring())
                        }
                    }
                }
            }
    ) {
        Text(
            text = "Tap to Move the Circle",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(50.dp)
                .graphicsLayer {
                    shadowElevation = 8.dp.toPx()
                    shape = CircleShape
                },
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            style = MaterialTheme.typography.headlineSmall
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .offset { offset.value.toIntOffset() }
                .graphicsLayer {
                    scaleX = scale.value
                    scaleY = scale.value
                }
                .background(
                    color = Color(0xFF2979FF),
                    shape = CircleShape
                )
                .shadow(
                    elevation = 16.dp,
                    shape = CircleShape,
                    spotColor = Color.White.copy(alpha = 0.4f)
                )
        )
    }
}
private fun Offset.toIntOffset() = IntOffset(x.roundToInt(), y.roundToInt())
