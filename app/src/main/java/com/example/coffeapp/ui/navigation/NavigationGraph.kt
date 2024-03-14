package com.example.coffeapp.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.coffeapp.ui.screen.GeneratePrimesScreen
import com.example.coffeapp.ui.screen.GetStartedScreen

fun NavGraphBuilder.addNavigationGraph(
    navController: NavController
){
    composable(Screen.GetStartedScreen.route) {
        GetStartedScreen(navController = navController)
    }
    composable(Screen.GeneratePrimesScreen.route) {
        GeneratePrimesScreen()
    }
}