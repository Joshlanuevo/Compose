package com.vancoding.todo.data.models

import androidx.compose.ui.graphics.Color
import com.vancoding.todo.ui.theme.HighPriorityColor
import com.vancoding.todo.ui.theme.LowPriorityColor
import com.vancoding.todo.ui.theme.MediumPriorityColor
import com.vancoding.todo.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor),
}