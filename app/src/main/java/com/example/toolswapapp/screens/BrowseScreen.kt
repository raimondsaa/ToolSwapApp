@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.toolswapapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.toolswapapp.ui.components.ToolCard
import com.example.toolswapapp.viewmodel.ToolViewModel

@Composable
fun BrowseScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ToolViewModel = viewModel()
) {
    val tools by viewModel.tools.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Available Tools",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(tools) { tool ->
                ToolCard(tool = tool)
            }
        }
    }
}
