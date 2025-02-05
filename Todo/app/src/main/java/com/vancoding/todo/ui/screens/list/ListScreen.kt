package com.vancoding.todo.ui.screens.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.vancoding.todo.R
import com.vancoding.todo.ui.theme.fabBackgroundColor
import com.vancoding.todo.ui.viewmodel.SharedViewModel
import com.vancoding.todo.utils.Action
import com.vancoding.todo.utils.SearchAppBarState
import kotlinx.coroutines.launch

@Composable
fun ListScreen(
    action: Action,
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel,
) {
    LaunchedEffect(key1 = action) {
        sharedViewModel.handleDatabaseActions(action = action)
    }

    val allTasks by sharedViewModel.allTasks.collectAsState()
    val searchTasks by sharedViewModel.searchTasks.collectAsState()
    val sortState by sharedViewModel.sortState.collectAsState()
    val lowPriorityTasks by sharedViewModel.lowPriorityTasks.collectAsState()
    val highPriorityTasks by sharedViewModel.highPriorityTasks.collectAsState()
    val searchAppBarState: SearchAppBarState = sharedViewModel.searchAppBarState
    val searchTextState: String = sharedViewModel.searchTextState
    val snackbarHostState = remember { SnackbarHostState() }

    DisplaySnackBar(
        snackbarHostState = snackbarHostState,
        onComplete = { sharedViewModel.updateAction(newAction = it) },
        onUndoClicked =  {
            sharedViewModel.updateAction(newAction = it)
        },
        taskTitle = sharedViewModel.title,
        action = action,
    )

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState,
            )
        },
        content = { contentPadding ->
            Box(
                modifier = Modifier.padding(contentPadding)
            ) {
                ListContent(
                    allTasks = allTasks,
                    searchedTasks = searchTasks,
                    lowPriorityTasks = lowPriorityTasks,
                    highPriorityTasks = highPriorityTasks,
                    sortState = sortState,
                    searchedAppBarState = searchAppBarState,
                    onSwipeToDelete = { action, task ->
                        sharedViewModel.updateAction(newAction = action)
                        sharedViewModel.updateTaskFields(selectedTask = task)
                        snackbarHostState.currentSnackbarData?.dismiss()
                    },
                    navigateToTaskScreen = navigateToTaskScreen,
                )
            }
        },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)
        },
    )
}

@Composable
fun ListFab(
    onFabClicked: (taskId: Int) -> Unit,
) {
    FloatingActionButton(
        onClick = {
            onFabClicked(-1)
        },
        containerColor = MaterialTheme.colorScheme.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button),
        )
    }
}

@Composable
fun DisplaySnackBar(
    snackbarHostState: SnackbarHostState,
    onComplete: (Action) -> Unit,
    onUndoClicked: (Action) -> Unit,
    taskTitle: String,
    action: Action,
) {
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = action) {
        if (action != Action.NO_ACTION) {
            scope.launch {
                val snackBarResult = snackbarHostState.showSnackbar(
                    message = setMessage(action, taskTitle),
                    actionLabel = setActionLabel(action = action),
                    duration = SnackbarDuration.Short,
                )
                undoDeleteTask(
                    action = action,
                    snackbarResult = snackBarResult,
                    onUndoClicked = onUndoClicked,
                )
            }
            onComplete(Action.NO_ACTION)
        }
    }
}

private fun setActionLabel(action: Action): String {
    return if (action.name == "DELETE") {
        "UNDO"
    } else {
        "OK"
    }
}

private fun undoDeleteTask(
    action: Action,
    snackbarResult: SnackbarResult,
    onUndoClicked: (Action) -> Unit,
) {
    if (snackbarResult == SnackbarResult.ActionPerformed
        && action == Action.DELETE
    ) {
        onUndoClicked(Action.UNDO)
    }
}

private fun setMessage(
    action: Action,
    taskTitle: String,
): String {
    return when (action) {
        Action.DELETE_ALL -> "All Tasks Removed."
        else -> "${action.name}: $taskTitle"
    }
}