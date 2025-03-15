package com.rajan.mapd721assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Main Menu", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navController.navigate("animation1") }) {
            Text("Animation 1 Demo")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navController.navigate("animation2") }) {
            Text("Animation 2 Demo")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navController.navigate("animation3") }) {
            Text("Animation 3 Demo")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navController.navigate("animation4") }) {
            Text("Animation 4 Demo")
        }

        Spacer(modifier = Modifier.height(30.dp))
        Text("Peter Doe", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text("123456445", fontSize = 16.sp, color = MaterialTheme.colors.primary)
    }
}