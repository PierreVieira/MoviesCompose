package com.example.moviescompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.example.moviescompose.navigation.NavigationComponent
import com.example.moviescompose.ui.theme.MoviesComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavigationComponent(navController = rememberNavController())
                }
            }
        }
    }
}