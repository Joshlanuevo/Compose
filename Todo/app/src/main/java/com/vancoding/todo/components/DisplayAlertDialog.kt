package com.vancoding.todo.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.vancoding.todo.R

@Composable
fun DisplayAlertDialog(
    title: String,
    message: String,
    openDialog: Boolean,
    closeDialog: () -> Unit,
    onYesClicked: () -> Unit,
) {
    if (openDialog) {
        AlertDialog(
            onDismissRequest = { closeDialog() },
            title = {
                Text(
                    text = title,
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    fontWeight = FontWeight.Bold,
                )
            },
            text = {
                Text(
                    text = message,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Normal,
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        onYesClicked()
                        closeDialog()
                    }
                ) {
                    Text(text = stringResource(id = R.string.yes_btn))
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = { closeDialog() }
                ) {
                    Text(text = stringResource(id = R.string.no_btn))
                }
            }
        )
    }
}

@Composable
@Preview
fun DisplayAlertDialogPreview() {
    DisplayAlertDialog(
        title = "Title",
        message = "Message",
        openDialog = true,
        onYesClicked = {},
        closeDialog = {},
    )
}