package com.vancoding.todo.ui.screens.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.vancoding.todo.R
import com.vancoding.todo.ui.theme.fabBackgroundColor

@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
) {
    Scaffold(
        topBar = {
            ListAppBar()
        },
        content = { contentPadding ->
            Box(modifier = Modifier.padding(contentPadding))
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
@Preview
fun ListScreenPreview() {
    ListScreen(navigateToTaskScreen = {})
}