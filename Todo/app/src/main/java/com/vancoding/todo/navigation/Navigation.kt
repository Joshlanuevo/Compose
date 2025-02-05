package com.vancoding.todo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.vancoding.todo.navigation.destinations.listComposable
//import com.vancoding.todo.navigation.destinations.splashComposable
import com.vancoding.todo.navigation.destinations.taskComposable
import com.vancoding.todo.ui.viewmodel.SharedViewModel
import com.vancoding.todo.utils.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN,
    ) {
//        splashComposable(
//            navigateToTaskScreen = screen.splash,
//        )
        listComposable(
            navigateToTaskScreen = screen.list,
            sharedViewModel = sharedViewModel,
        )
        taskComposable(
            navigateToListScreen = screen.task,
            sharedViewModel = sharedViewModel,
        )
    }
}