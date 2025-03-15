package com.rajan.mapd721assignment3

import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Animation1Screen() {
    var toggle by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Animation 1 Demo", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { toggle = !toggle }) {
            Text("Toggle Animation")
        }

        AnimatedContent(targetState = toggle) { state ->
            if (state) {
                Text("Hello, Jetpack Compose!", fontSize = 18.sp, color = MaterialTheme.colors.primary)
            } else {
                Text("Welcome to Animation Demo!", fontSize = 18.sp, color = MaterialTheme.colors.secondary)
            }
        }
    }
}