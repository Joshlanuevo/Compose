package com.vancoding.userlist.ui.screens.home

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.vancoding.userlist.ui.theme.topAppBarBackgroundColor
import com.vancoding.userlist.ui.theme.topAppBarContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(
    onSearchedClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = "Users",
                color = MaterialTheme.colorScheme.topAppBarContentColor,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
        ),
        actions = {
            IconButton(
                onClick = onSearchedClick,
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = MaterialTheme.colorScheme.topAppBarContentColor,
                )
            }
        },
    )
}

@Composable
@Preview
fun HomeTopAppBarPreview() {
    HomeTopAppBar(
        onSearchedClick = {},
    )
}