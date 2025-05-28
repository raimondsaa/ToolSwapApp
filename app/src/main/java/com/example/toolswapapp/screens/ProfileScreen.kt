@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.toolswapapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.toolswapapp.R
import com.example.toolswapapp.navigation.Routes

@Composable
fun ProfileScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_tool_placeholder),
            contentDescription = "Profile Avatar",
            modifier = Modifier
                .size(80.dp)
        )

        Text("Welcome back!", style = MaterialTheme.typography.titleLarge)
        Text("user@example.com", style = MaterialTheme.typography.bodyLarge)

        Button(
            onClick = {
                navController.navigate(Routes.LOGIN) {
                    popUpTo(Routes.LOGIN) { inclusive = true }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text("Log Out")
        }
    }
}
