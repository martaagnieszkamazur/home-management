package com.martamazurkozlowska.homemanagement.ui.components.button

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.homemanagement.ui.theme.AppColors
import com.martamazurkozlowska.homemanagement.ui.theme.AppTypography

@Composable
fun PrimaryButton(
    text: String?,
    icon: Painter?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = AppColors.green500, contentColor = AppColors.gray50),
        onClick = onClick,
        modifier = modifier
    ) {
        if (icon != null) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Spacer(
                modifier = Modifier.width(8.dp)
            )
        }

        if (text != null) {
            Text(
                text = text,
                style = AppTypography.bodyMediumBlack,
                color = AppColors.gray50,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview
@Composable
private fun PrimaryButtonPreview() {
    PrimaryButton(
        text = "Add task",
        icon = null,
        onClick = {},
    )
}