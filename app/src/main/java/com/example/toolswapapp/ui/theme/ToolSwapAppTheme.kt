@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.toolswapapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF00897B),
    onPrimary = Color.White,
    secondary = Color(0xFFFFB300),
    background = Color(0xFFF5F5F5),
    surface = Color.White,
    onBackground = Color(0xFF1E1E1E),
    onSurface = Color(0xFF1E1E1E),
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF00BFA5),
    onPrimary = Color.Black,
    secondary = Color(0xFFFFC107),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onBackground = Color.White,
    onSurface = Color.White,
)

@Composable
fun ToolSwapAppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (useDarkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        shapes = Shapes(),
        content = content
    )
}
