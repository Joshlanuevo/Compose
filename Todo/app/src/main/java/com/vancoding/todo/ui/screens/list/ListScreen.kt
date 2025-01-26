package com.vancoding.todo.ui.screens.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
) {

}


@Composable
@Preview
fun ListScreenPreview() {
    ListScreen(navigateToTaskScreen = {})
}