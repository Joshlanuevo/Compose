package com.vancoding.userlist.ui.navigation

import com.vancoding.userlist.utils.Action
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data class Home(val action: Action = Action.NO_ACTION) : Screen()
    @Serializable
    data class UserDetail(val userId: Int) : Screen()
}