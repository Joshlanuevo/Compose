package com.vancoding.userlist.ui.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vancoding.userlist.model.User

@Composable
fun UserList(
    users: List<User>,
    onItemClick: (User) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(users) { user ->
            UserItem(
                user = user,
                onItemClick = onItemClick,
            )
        }
    }
}