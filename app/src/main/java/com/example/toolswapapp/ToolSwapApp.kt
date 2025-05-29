@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.toolswapapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.toolswapapp.navigation.NavGraph
import com.example.toolswapapp.navigation.Routes
import com.example.toolswapapp.ui.theme.ToolSwapAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolSwapApp() {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route

    val showTopAndBottomBar = currentRoute != Routes.LOGIN

    ToolSwapAppTheme {
        Scaffold(
            topBar = {
                if (showTopAndBottomBar) {
                    TopAppBar(
                        title = {
                            Text(
                                text = when (currentRoute) {
                                    Routes.TOOLS -> "My Tools"
                                    Routes.BROWSE -> "Browse Tools"
                                    Routes.PROFILE -> "Profile"
                                    else -> "ToolSwap"
                                },
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    )
                }
            },
            bottomBar = {
                if (showTopAndBottomBar) {
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
    val navItems = listOf(
        BottomNavItem("Tools", Routes.TOOLS, Icons.Default.Construction),
        BottomNavItem("Browse", Routes.BROWSE, Icons.Default.Search),
        BottomNavItem("Profile", Routes.PROFILE, Icons.Default.Person)
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 6.dp
    ) {
        navItems.forEach { item ->
            val selected = currentRoute == item.route
            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (!selected) {
                        navController.navigate(item.route)
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                )
            )
        }
    }
}

data class BottomNavItem(val label: String, val route: String, val icon: ImageVector)
