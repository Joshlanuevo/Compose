package com.vancoding.userlist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.vancoding.userlist.ui.screens.home.HomeScreen
import com.vancoding.userlist.ui.screens.user.UserDetailScreen
import com.vancoding.userlist.viewmodel.UserListViewModel

@Composable
fun NavigationStack(
    navController: NavHostController,
    userListViewModel: UserListViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                navigateToUserDetail = { userId ->
                    navController.navigate(Screen.UserDetail.createRoute(userId))
                },
                userListViewModel = userListViewModel
            )
        }

        composable(
            route = Screen.UserDetail.route,
            arguments = listOf(navArgument("userId") { type = NavType.IntType })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getInt("userId") ?: return@composable
            UserDetailScreen(
                userId = userId,
                navigateBack = { navController.popBackStack() },
                userListViewModel = userListViewModel
            )
        }
    }
}