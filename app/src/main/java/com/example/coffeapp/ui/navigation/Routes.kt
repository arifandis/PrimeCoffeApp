package com.example.coffeapp.ui.navigation

sealed class Screen(val route: String) {
    data object GetStartedScreen : Screen("get_started_screen")
    data object GeneratePrimesScreen : Screen("generate_primes_screen")
}