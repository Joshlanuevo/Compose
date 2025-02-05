package com.vancoding.todo.ui.screens.task

import android.content.Context
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.vancoding.todo.data.models.Priority
import com.vancoding.todo.data.models.ToDoTask
import com.vancoding.todo.ui.viewmodel.SharedViewModel
import com.vancoding.todo.utils.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit,
) {
    val title: String = sharedViewModel.title
    val description: String = sharedViewModel.description
    val priority: Priority = sharedViewModel.priority
    val context = LocalContext.current

    BackHandler {
        navigateToListScreen(Action.NO_ACTION)
    }

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = { action ->
                    if (action == Action.NO_ACTION) {
                        navigateToListScreen(action)
                    } else {
                        if (sharedViewModel.validateFields()) {
                            navigateToListScreen(action)
                        } else {
                            displayToast(context = context)
                        }
                    }
                },
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier.padding(paddingValues)
            ) {
                TaskContent(
                    title = title,
                    onTitleChange = {
                        sharedViewModel.updateTitle(it)
                    },
                    description = description,
                    onDescriptionChange = {
                        sharedViewModel.updateDescription(newDescription = it)
                    },
                    priority = priority,
                    onPrioritySelected = {
                        sharedViewModel.updatePriority(newPriority = it)
                    },
                )
            }
        },
    )
}

fun displayToast(context: Context) {
    Toast.makeText(
        context,
        "Fields Empty",
        Toast.LENGTH_SHORT
    ).show()
}