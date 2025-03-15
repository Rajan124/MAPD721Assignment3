package com.rajan.mapd721assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rajan.mapd721assignment3.ui.theme.MAPD721Assignment3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun MainMenu(navController: NavController) {
    // Background color for the screen
    val backgroundColor = Color(0xFFBBDEFB) // Light Blue

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor) // Apply background color
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center // Center items vertically
        ) {
            // Title Text
            Text(
                text = "Main Menu",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White // Contrasting text color for readability
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Buttons for navigation
            Button(
                onClick = { navController.navigate("animation1") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Animation 1 Demo")
            }
            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { navController.navigate("animation2") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Animation 2 Demo")
            }
            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { navController.navigate("animation3") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Animation 3 Demo")
            }
            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { navController.navigate("animation4") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Animation 4 Demo")
            }

            Spacer(modifier = Modifier.height(30.dp))


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Rajan Boudel",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
                Text(
                    text = "301365245",
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.7f) // Slightly faded for subtle effect
                )
            }
        }
    }
}