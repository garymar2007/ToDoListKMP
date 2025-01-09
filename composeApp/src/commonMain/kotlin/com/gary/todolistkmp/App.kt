package com.gary.todolistkmp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.gary.todolistkmp.presentation.screen.home.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

val lightRedColor = Color(color = 0xFFF57D88)
val darkRedColor = Color(color = 0xFF77000B)

@Composable
@Preview
fun App() {
    MaterialTheme {
        val lightColors = lightColorScheme(
            primary = lightRedColor,
            onPrimary = darkRedColor,
            primaryContainer = lightRedColor,
            onPrimaryContainer = darkRedColor
        )
        val darkColors = darkColorScheme(
            primary = darkRedColor,
            onPrimary = lightRedColor,
            primaryContainer = darkRedColor,
            onPrimaryContainer = lightRedColor
        )
        val colors by mutableStateOf(
            if (isSystemInDarkTheme()) darkColors else lightColors
        )

        MaterialTheme(colorScheme = colors) {
            Navigator(HomeScreen()) {
                SlideTransition(it)
            }
        }
    }
}