@file:OptIn(ExperimentalMaterial3Api::class)

// --- ToolSwapApp.kt ---
package com.example.toolswapapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.toolswapapp.navigation.NavGraph
import com.example.toolswapapp.navigation.Routes
import com.example.toolswapapp.ui.theme.ToolSwapAppTheme

@Composable
fun ToolSwapApp() {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route

    val showBottomBar = currentRoute != Routes.LOGIN

    ToolSwapAppTheme {
        Scaffold(
            topBar = {
                if (showBottomBar) {
                    TopAppBar(
                        title = {
                            Text(
                                text = currentRoute?.let {
                                    when (it) {
                                        Routes.TOOLS -> "My Tools"
                                        Routes.BROWSE -> "Browse Tools"
                                        Routes.PROFILE -> "Profile"
                                        else -> "ToolSwap"
                                    }
                                } ?: "ToolSwap",
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        },
                        actions = {
                            IconButton(onClick = { /* Search or settings action */ }) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search",
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    )
                }
            },
            bottomBar = {
                if (showBottomBar) {
                    BottomNavigationBar(navController, currentRoute)
                }
            }
        ) { innerPadding ->
            NavGraph(navController = navController, padding = innerPadding)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController, currentRoute: String?) {
    val items = listOf(
        BottomNavItem("Tools", Routes.TOOLS, Icons.Default.Construction),
        BottomNavItem("Browse", Routes.BROWSE, Icons.Default.Search),
        BottomNavItem("Profile", Routes.PROFILE, Icons.Default.Person)
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        tonalElevation = 4.dp
    ) {
        items.forEach { item ->
            val selected = currentRoute == item.route
            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (!selected) navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        tint = if (selected)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        color = if (selected)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                alwaysShowLabel = true
            )
        }
    }
}

data class BottomNavItem(val label: String, val route: String, val icon: ImageVector)
