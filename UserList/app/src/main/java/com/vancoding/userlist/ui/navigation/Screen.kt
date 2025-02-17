package com.vancoding.userlist.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object User : Screen("user")
}