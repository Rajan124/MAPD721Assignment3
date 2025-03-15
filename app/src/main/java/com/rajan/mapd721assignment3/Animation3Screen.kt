package com.rajan.mapd721assignment3

import androidx.compose.animation.core.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun Animation3Screen() {
    val transition = rememberInfiniteTransition()
    val alpha by transition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(animation = tween(1000))
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Animation 3 Demo", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "This text fades in and out",
            fontSize = 18.sp,
            modifier = Modifier.graphicsLayer { this.alpha = alpha }
        )
    }
}