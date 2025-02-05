package com.vancoding.todo.navigation

import com.vancoding.todo.utils.Action
import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {
    @Serializable
    data class List(val action: Action = Action.NO_ACTION) : Screens()
    @Serializable
    data class Task(val id: Int) : Screens()
}