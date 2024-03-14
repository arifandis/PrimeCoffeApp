package com.example.coffeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import com.example.coffeapp.ui.navigation.Screen
import com.example.coffeapp.ui.navigation.addNavigationGraph
import com.example.coffeapp.ui.theme.CoffeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appState = rememberAppState()
            val startingRoute = Screen.GetStartedScreen.route

            CoffeAppTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    NavHost(
                        navController = appState.navController,
                        startDestination = startingRoute,
                        modifier = Modifier.background(Color.White).padding(it).statusBarsPadding()
                            .navigationBarsPadding()){
                        addNavigationGraph(
                            navController = appState.navController
                        )
                    }
                }
            }
        }
    }
}