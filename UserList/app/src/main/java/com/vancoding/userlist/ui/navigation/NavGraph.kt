package com.vancoding.userlist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vancoding.userlist.ui.screens.destinations.userDetailComposable
import com.vancoding.userlist.ui.screens.destinations.userListComposable
import com.vancoding.userlist.ui.screens.home.HomeScreen
import com.vancoding.userlist.ui.screens.user.UserScreen
import com.vancoding.userlist.utils.Action
import com.vancoding.userlist.viewmodel.UserListViewModel

@Composable
fun NavigationStack(
    navController: NavHostController,
    userListViewModel: UserListViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.toString(),
    ) {
        userListComposable(
            navigateToUserDetail = { userId ->
                navController.navigate(Screen.UserDetail(userId = userId).toString())
            },
            userListViewModel = userListViewModel,
        )
        userDetailComposable(
            navigateBack = { action ->
                if (action == Action.NAVIGATE_BACK) {
                    navController.popBackStack()
                }
            },
            userListViewModel = userListViewModel,
        )
    }
}