package com.example.coffeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController()
) = remember(
    navController
) {
    RememberAppState(navController)
}

class RememberAppState(
    val navController: NavHostController
) {
    private val currentRoute: String? get() = navController.currentDestination?.route
}