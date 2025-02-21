package com.vancoding.userlist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vancoding.userlist.ui.screens.home.HomeScreen
import com.vancoding.userlist.ui.screens.user.UserScreen
import com.vancoding.userlist.viewmodel.UserListViewModel

@Composable
fun NavigationStack(
    navController: NavHostController,
    userListViewModel: UserListViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                navController = navController,
                userListViewModel = userListViewModel,
            )
        }
        composable(Screen.User.route) {
            UserScreen(navController = navController)
        }
    }
}