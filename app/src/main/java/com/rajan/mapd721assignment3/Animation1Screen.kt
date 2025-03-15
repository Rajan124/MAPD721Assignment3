package com.rajan.mapd721assignment3

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Animation1Screen() {
    var expanded by remember { mutableStateOf(false) }

    Surface(
        color = MaterialTheme.colors.primary,
        onClick = { expanded = !expanded },
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth(),
        elevation = if (expanded) 8.dp else 2.dp,
        shape = RoundedCornerShape(if (expanded) 16.dp else 8.dp)
    ) {
        AnimatedContent(
            targetState = expanded,
            transitionSpec = {
                // Separate specs for different animation types
                val offsetAnimationSpec = tween<IntOffset>(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
                val alphaAnimationSpec = tween<Float>(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )

                (fadeIn(alphaAnimationSpec) +
                        slideInVertically(offsetAnimationSpec) { height -> (height * 0.1f).toInt() } +
                        scaleIn(alphaAnimationSpec)).togetherWith(
                    fadeOut(alphaAnimationSpec) +
                            slideOutVertically(offsetAnimationSpec) { height -> (-height * 0.1f).toInt() } +
                            scaleOut(alphaAnimationSpec)
                ) using SizeTransform { initialSize, targetSize ->
                    keyframes {
                        if (targetState) {
                            IntSize(targetSize.width, initialSize.height) at 150
                            IntSize(targetSize.width, targetSize.height) at 300
                        } else {
                            IntSize(initialSize.width, targetSize.height) at 150
                            IntSize(targetSize.width, targetSize.height) at 300
                        }
                    }
                }
            },
            label = "enhanced_animation"
        ) { targetExpanded ->
            if (targetExpanded) {
                Expanded()
            } else {
                ContentIcon()
            }
        }
    }
}


@Composable
fun Expanded() {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.Star,
            contentDescription = "Star",
            modifier = Modifier.size(32.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Detailed Information",
            style = MaterialTheme.typography.h6.copy(color = Color.White)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            style = MaterialTheme.typography.body1.copy(color = Color.White),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContentIcon() {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.Star,
            contentDescription = "Tap",
            modifier = Modifier.size(48.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Tap to Expand",
            style = MaterialTheme.typography.button.copy(color = Color.White)
        )
    }
}