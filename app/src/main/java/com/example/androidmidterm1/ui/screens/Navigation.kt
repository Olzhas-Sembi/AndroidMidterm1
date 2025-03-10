package com.example.androidmidterm1.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("gameList") { GameListScreen(navController) }
        composable("gameDetail/{gameTitle}") { backStackEntry ->
            val gameTitle = backStackEntry.arguments?.getString("gameTitle") ?: ""
            GameDetailScreen(gameTitle, navController)
        }
    }
}
