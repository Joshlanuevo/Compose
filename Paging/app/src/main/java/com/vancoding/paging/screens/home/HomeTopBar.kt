package com.vancoding.paging.screens.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun HomeTopBar(
    onSearchClicked: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = "Home",
                color = MaterialTheme.colorScheme.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
        actions = {
            IconButton(
                onClick = onSearchClicked,
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = MaterialTheme.colorScheme.topAppBarContentColor
                )
            }
        }
    )
}