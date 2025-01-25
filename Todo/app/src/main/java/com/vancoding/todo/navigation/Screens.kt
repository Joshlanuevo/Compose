package com.vancoding.todo.navigation

import androidx.navigation.NavHostController
import com.vancoding.todo.utils.Action
import com.vancoding.todo.utils.Constants.LIST_SCREEN

class Screens(navHostController: NavHostController) {
    val list: (Action) -> Unit = { action ->
        navHostController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
    val task: (Int) -> Unit = { taskId ->
        navHostController.navigate("task/$taskId")
    }
}