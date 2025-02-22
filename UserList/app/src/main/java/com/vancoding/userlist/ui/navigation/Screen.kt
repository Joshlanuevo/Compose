package com.vancoding.userlist.ui.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object UserDetail : Screen("userDetail/{userId}") {
        fun createRoute(userId: Int) = "userDetail/$userId"
    }
}