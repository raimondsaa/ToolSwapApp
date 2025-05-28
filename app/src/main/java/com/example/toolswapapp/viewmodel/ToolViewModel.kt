package com.example.toolswapapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.toolswapapp.model.Tool
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ToolViewModel : ViewModel() {

    private val _tools = MutableStateFlow(
        listOf(
            Tool(1, "Hammer", "Good"),
            Tool(2, "Screwdriver", "Excellent"),
            Tool(3, "Cordless Drill", "Fair")
        )
    )
    val tools: StateFlow<List<Tool>> = _tools

    fun addTool(name: String, condition: String) {
        val newTool = Tool(
            id = (_tools.value.maxOfOrNull { it.id } ?: 0) + 1,
            name = name,
            condition = condition
        )
        _tools.value = _tools.value + newTool
    }
}