package com.example.toolswapapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.toolswapapp.R
import com.example.toolswapapp.model.Tool

@Composable
fun ToolCard(tool: Tool) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 100.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val imageRes = when (tool.name.lowercase()) {
                "hammer" -> R.drawable.ic_hammer
                "screwdriver" -> R.drawable.ic_screwdriver
                "cordless drill", "drill" -> R.drawable.ic_drill
                else -> R.drawable.logo
            }

            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "${tool.name} image",
                modifier = Modifier
                    .size(56.dp)
                    .padding(end = 16.dp)
            )

            Column {
                Text(
                    text = tool.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Condition: ${tool.condition}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
