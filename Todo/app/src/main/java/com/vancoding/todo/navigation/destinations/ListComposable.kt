package com.vancoding.todo.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.vancoding.todo.navigation.Screens
import com.vancoding.todo.ui.screens.list.ListScreen
import com.vancoding.todo.ui.viewmodel.SharedViewModel
import com.vancoding.todo.utils.Action

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel,
) {
    composable<Screens.List> { navBackStackEntry ->
        val action = navBackStackEntry.toRoute<Screens.List>().action
        var myAction by rememberSaveable { mutableStateOf(Action.NO_ACTION) }
        val databaseAction = sharedViewModel.action

         LaunchedEffect(key1 = myAction) {
             if (action != myAction) {
                 myAction = action
                 sharedViewModel.updateAction(newAction = action)
             }
         }

        ListScreen(
            action = databaseAction,
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel,
        )
    }
}