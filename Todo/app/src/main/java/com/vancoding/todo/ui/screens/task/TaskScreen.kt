package com.vancoding.todo.ui.screens.task

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vancoding.todo.utils.Action

@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit,
) {
    Scaffold(
        topBar = {
            TaskAppBar(navigateToListScreen = navigateToListScreen)
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier.padding(paddingValues)
            )
        },
    )
}