package com.vancoding.paging.screens.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha
import com.vancoding.paging.ui.theme.topAppBarBackgroundColor
import com.vancoding.paging.ui.theme.topAppBarContentColor

@Composable
fun SearchWidget(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .semantics {
                    contentDescription = "SearchWidget"
                },
            shadowElevation = 5.dp,
            color = MaterialTheme.colorScheme.topAppBarBackgroundColor,
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "TextField"
                    },
                value = text,
                onValueChange = { onTextChange(it) },
                placeholder = {
                    Text(
                        modifier = Modifier
                            .alpha(alpha = ContentAlpha.medium),
                        text = "Search here...",
                        color = Color.White,
                    )
                },
                textStyle = TextStyle(
                    color = MaterialTheme.colorScheme.topAppBarContentColor,
                ),
                singleLine = true,
                leadingIcon = {
                    IconButton(
                        modifier = Modifier
                            .alpha(alpha = ContentAlpha.medium),
                        onClick = {},
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon",
                            tint = MaterialTheme.colorScheme.topAppBarContentColor,
                        )
                    }
                },
                trailingIcon = {
                    IconButton(
                        modifier = Modifier
                            .semantics {
                                contentDescription = "CloseButton"
                            },
                        onClick = {
                            if (text.isNotEmpty()) {
                                onTextChange("")
                            } else {
                                onCloseClicked()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close Icon",
                            tint = MaterialTheme.colorScheme.topAppBarContentColor,
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onSearchClicked(text)
                    }
                ),
                colors = TextFieldDefaults.colors(
                    cursorColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
                    unfocusedContainerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
                    focusedContainerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
                    disabledContainerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
                    errorContainerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                ),
            )
        }
    }
}

@Composable
@Preview
fun SearchWidgetPreview() {
    SearchWidget(
        text = "Search",
        onTextChange = {},
        onSearchClicked = {},
        onCloseClicked = {},
    )
}