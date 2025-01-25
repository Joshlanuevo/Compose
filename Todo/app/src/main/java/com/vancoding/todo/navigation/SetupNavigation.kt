package com.vancoding.todo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.vancoding.todo.utils.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navHostController: NavHostController
) {
    val screen = remember(navHostController) {
        Screens(navHostController = navHostController)
    }

    NavHost(
        navController = navHostController,
        startDestination = LIST_SCREEN
    ) {

    }
}