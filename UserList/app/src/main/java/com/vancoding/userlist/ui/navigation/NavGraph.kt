package com.vancoding.userlist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vancoding.userlist.ui.screens.HomeScreen
import com.vancoding.userlist.ui.screens.UserScreen

@Composable
fun NavigationStack(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.User.route) {
            UserScreen(navController = navController)
        }
    }
}