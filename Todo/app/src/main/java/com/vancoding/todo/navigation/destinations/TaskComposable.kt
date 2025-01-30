package com.vancoding.todo.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.vancoding.todo.ui.screens.task.TaskScreen
import com.vancoding.todo.ui.viewmodel.SharedViewModel
import com.vancoding.todo.utils.Action
import com.vancoding.todo.utils.Constants.TASK_ARGUMENT_KEY
import com.vancoding.todo.utils.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit,
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        sharedViewModel.getSelectedTask(taskId = taskId)

        LaunchedEffect(key1 = selectedTask) {
            sharedViewModel.updateTaskFields(selectedTask = selectedTask)
        }

        TaskScreen(
            selectedTask = selectedTask,
            sharedViewModel = sharedViewModel,
            navigateToListScreen = navigateToListScreen,
        )
    }
}