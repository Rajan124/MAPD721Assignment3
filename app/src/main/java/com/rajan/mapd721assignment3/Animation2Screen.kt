package com.rajan.mapd721assignment3

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Animation2Screen() {
    var isVisible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Animation 2 Demo", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { isVisible = !isVisible }) {
            Text("Toggle Visibility")
        }

        AnimatedVisibility(visible = isVisible) {
            Card(
                modifier = Modifier.padding(16.dp),
                elevation = 8.dp
            ) {
                Text(
                    text = "This is an animated text block.",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}