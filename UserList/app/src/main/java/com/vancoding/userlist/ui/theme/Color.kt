package com.vancoding.userlist.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Blue80 = Color(0xFFB3CDE0)
val BlueGrey80 = Color(0xFFB0BEC5)
val LightBlue80 = Color(0xFFA7C7E7)

val Blue40 = Color(0xFF1565C0)
val BlueGrey40 = Color(0xFF546E7A)
val LightBlue40 = Color(0xFF039BE5)

val ColorScheme.topAppBarContentColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.White else BlueGrey80

val ColorScheme.topAppBarBackgroundColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Blue40 else BlueGrey40