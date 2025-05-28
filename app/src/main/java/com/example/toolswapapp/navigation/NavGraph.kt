package com.example.toolswapapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.toolswapapp.screens.BrowseScreen
import com.example.toolswapapp.screens.LoginScreen
import com.example.toolswapapp.screens.MyToolsScreen
import com.example.toolswapapp.screens.ProfileScreen

object Routes {
    const val LOGIN = "login"
    const val TOOLS = "tools"
    const val BROWSE = "browse"
    const val PROFILE = "profile"
}

@Composable
fun NavGraph(navController: NavHostController, padding: PaddingValues = PaddingValues()) {
    NavHost(navController = navController, startDestination = Routes.LOGIN) {
        composable(Routes.LOGIN) {
            LoginScreen(navController)
        }
        composable(Routes.TOOLS) {
            MyToolsScreen(navController, Modifier.padding(padding))
        }
        composable(Routes.BROWSE) {
            BrowseScreen(navController, Modifier.padding(padding))
        }
        composable(Routes.PROFILE) {
            ProfileScreen(navController, Modifier.padding(padding))
        }
    }
}