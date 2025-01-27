package com.vancoding.todo.ui.screens.list

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.vancoding.todo.R
import com.vancoding.todo.ui.theme.topAppBarBackgroundColor
import com.vancoding.todo.ui.theme.topAppBarContentColor

@Composable
fun ListAppBar() {
    DefaultListAppBar(
        onSearchClicked = {},
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = "Tasks",
                color = MaterialTheme.colorScheme.topAppBarContentColor,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
        ),
        actions = {
            ListAppBarActions(
                onSearchClicked = onSearchClicked,
            )
        },
    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
) {
    SearchActions(
        onSearchClicked = onSearchClicked,
    )
}

@Composable
fun SearchActions(
    onSearchClicked: () -> Unit,
) {
    IconButton(
        onClick = onSearchClicked,
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search_tasks),
            tint = MaterialTheme.colorScheme.topAppBarContentColor,
        )
    }
}



@Composable
@Preview
fun DefaultListAppBarPreview() {
    DefaultListAppBar(
        onSearchClicked = {},
    )
}