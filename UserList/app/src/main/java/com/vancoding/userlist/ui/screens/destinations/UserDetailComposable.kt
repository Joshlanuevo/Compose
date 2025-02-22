package com.vancoding.userlist.ui.screens.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.vancoding.userlist.ui.navigation.Screen
import com.vancoding.userlist.ui.screens.user.UserDetailScreen
import com.vancoding.userlist.utils.Action
import com.vancoding.userlist.viewmodel.UserListViewModel

fun NavGraphBuilder.userDetailComposable(
    navigateBack: (Action) -> Unit,
    userListViewModel: UserListViewModel,
) {
    composable(
        route = Screen.UserDetail(-1).toString(),
        arguments = listOf(navArgument("userId") { type = NavType.IntType }),
    ) { entry ->
        val userId = entry.arguments?.getInt("userId") ?: return@composable
        UserDetailScreen(
            userId = userId,
            navigateBack = navigateBack,
            userListViewModel = userListViewModel,
        )
    }
}