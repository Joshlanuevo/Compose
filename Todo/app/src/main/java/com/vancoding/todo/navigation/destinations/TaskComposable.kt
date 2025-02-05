package com.vancoding.todo.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.vancoding.todo.navigation.Screens
import com.vancoding.todo.ui.screens.task.TaskScreen
import com.vancoding.todo.ui.viewmodel.SharedViewModel
import com.vancoding.todo.utils.Action

fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit,
) {
    composable<Screens.Task> { navBackStackEntry ->
        val taskId = navBackStackEntry.toRoute<Screens.Task>().id
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        LaunchedEffect(key1 = taskId) {
            sharedViewModel.getSelectedTask(taskId = taskId)
        }

        LaunchedEffect(key1 = selectedTask) {
            if (selectedTask != null || taskId == -1) {
                sharedViewModel.updateTaskFields(selectedTask = selectedTask)
            }
        }

        TaskScreen(
            selectedTask = selectedTask,
            sharedViewModel = sharedViewModel,
            navigateToListScreen = navigateToListScreen,
        )
    }
}