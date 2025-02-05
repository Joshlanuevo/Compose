package com.vancoding.todo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.vancoding.todo.navigation.destinations.listComposable
import com.vancoding.todo.navigation.destinations.taskComposable
import com.vancoding.todo.ui.viewmodel.SharedViewModel

@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.List(),
    ) {
        listComposable(
            navigateToTaskScreen = { taskId ->
                navController.navigate(Screens.Task(id = taskId))
            },
            sharedViewModel = sharedViewModel,
        )
        taskComposable(
            navigateToListScreen = { action ->
                navController.navigate(Screens.List(action = action)) {
                    popUpTo(Screens.Task(id = -1)) { inclusive = true }
                }
            },
            sharedViewModel = sharedViewModel,
        )
    }
}