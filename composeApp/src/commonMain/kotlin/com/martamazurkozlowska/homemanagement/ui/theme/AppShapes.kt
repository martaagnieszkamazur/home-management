package com.martamazurkozlowska.homemanagement.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

object AppShapes {
    val button = RoundedCornerShape(10.dp)
    val label = RoundedCornerShape(
        topStart = 5.dp,
        topEnd = 1.dp,
        bottomEnd = 5.dp,
        bottomStart = 1.dp,
    )
    val taskItem = RoundedCornerShape(24.dp)
    val pickColor = CircleShape
    val textField = RoundedCornerShape(10.dp)
    val exportTextField = RoundedCornerShape(24.dp)
}