package com.rajan.mapd721assignment3

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "main") {
        composable("main") { MainMenu(navController) }
        composable("animation1") { Animation1Screen() }
        composable("animation2") { Animation2Screen() }
        composable("animation3") { Animation3Screen() }
        composable("animation4") { Animation4Screen() }
    }
}