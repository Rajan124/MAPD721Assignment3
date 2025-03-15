package com.rajan.mapd721assignment3

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Animation2Screen() {
    // State for visibility toggle
    var isVisible by remember { mutableStateOf(true) }
    // State for selection toggle
    var selected by remember { mutableStateOf(false) }

    // Transition for animating changes when `selected` is toggled
    val transition = updateTransition(selected, label = "selected state")
    val borderColor by transition.animateColor(label = "border color") { isSelected ->
        if (isSelected) Color.Magenta else Color.White
    }
    val elevation by transition.animateDp(label = "elevation") { isSelected ->
        if (isSelected) 10.dp else 2.dp
    }

    // Single background color
    val backgroundColor = Color(0xFFBBDEFB) // Light Blue

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor) // Single background color
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title Text
            Text(
                text = "Animation 2 Demo",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(12.dp))

            // Button to toggle visibility of the card
            Button(onClick = { isVisible = !isVisible }) {
                Text("Toggle Visibility")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // AnimatedVisibility for showing/hiding content
            AnimatedVisibility(visible = isVisible) {
                Card(
                    modifier = Modifier.padding(16.dp),
                    elevation = 8.dp,
                    backgroundColor = Color.White
                ) {
                    Text(
                        text = "This is an animated text block.",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(16.dp),
                        color = Color.DarkGray
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Surface with transition animations for selection state
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selected = !selected },
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, borderColor),
                elevation = elevation,
                color = if (selected) Color.LightGray else Color.White
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    // Static text at the top of the surface
                    Text(
                        text = "Tap to expand",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (selected) Color.Magenta else Color.DarkGray
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // AnimatedVisibility as part of the transition
                    transition.AnimatedVisibility(
                        visible = { targetSelected -> targetSelected },
                        enter = expandVertically(),
                        exit = shrinkVertically()
                    ) {
                        Text(
                            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                            fontSize = 16.sp,
                            color = Color.DarkGray
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // AnimatedContent as part of the transition
                    transition.AnimatedContent { targetState ->
                        if (targetState) {
                            Text(
                                text = " Welcome Rajan Boudel",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Magenta
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = "Phone",
                                tint = Color.Gray,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
