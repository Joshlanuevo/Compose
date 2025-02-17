package com.vancoding.userlist.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val AlmostWhiteBlue = Color(0xFFE3F2FD)  // Very Light Blue (Almost White)
val Blue80 = Color(0xFFB3CDE0)  // Soft Blue
val BlueGrey80 = Color(0xFFB0BEC5)  // Muted Blue Grey
val LightBlue80 = Color(0xFFA7C7E7)  // Light Sky Blue
val DeepBlue80 = Color(0xFF90CAF9)  // Deep Sky Blue
val NavyBlue80 = Color(0xFF5E92F3)  // Dark Navy Blue

// Dark Theme Colors
val Blue40 = Color(0xFF1565C0)  // Strong Blue
val BlueGrey40 = Color(0xFF546E7A)  // Deep Blue Grey
val LightBlue40 = Color(0xFF039BE5)  // Vibrant Light Blue
val DeepBlue40 = Color(0xFF0D47A1)  // Intense Deep Blue
val NavyBlue40 = Color(0xFF1A237E)  // Darkest Navy Blue

val ColorScheme.topAppBarContentColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) AlmostWhiteBlue else Color.White

val ColorScheme.topAppBarBackgroundColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Blue40 else NavyBlue40