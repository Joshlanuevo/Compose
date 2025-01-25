package com.vancoding.todo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.vancoding.todo.navigation.destinations.listComposable
import com.vancoding.todo.utils.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController,
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN,
    ) {
        listComposable(
            navigateToTaskScreen = screen.task
        )
    }
}