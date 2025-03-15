package com.rajan.mapd721assignment3

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight

@Composable
fun Animation3Screen() {
    // Infinite transition for fading text
    val textTransition = rememberInfiniteTransition(label = "textTransition")
    val alpha by textTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(animation = tween(1000)),
        label = "alpha"
    )

    // Infinite transition for background color
    val colorTransition = rememberInfiniteTransition(label = "colorTransition")
    val backgroundColor by colorTransition.animateColor(
        initialValue = Color(0xFF2979FF), // Blue
        targetValue = Color(0xFFFFC107), // Amber
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "backgroundColor"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor) // Animated background color
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Animation 3 Demo",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "This text fades in and out",
                fontSize = 18.sp,
                modifier = Modifier.graphicsLayer { this.alpha = alpha },
                color = Color.White
            )
        }
    }
}
