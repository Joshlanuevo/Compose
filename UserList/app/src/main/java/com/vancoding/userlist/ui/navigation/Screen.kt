package com.vancoding.userlist.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data class Home(val route: String = "home") : Screen()
    @Serializable
    data class UserDetail(val userId: Int) : Screen()
}