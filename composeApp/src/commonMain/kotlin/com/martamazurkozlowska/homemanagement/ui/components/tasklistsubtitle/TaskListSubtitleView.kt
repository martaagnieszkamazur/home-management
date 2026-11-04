package com.martamazurkozlowska.homemanagement.ui.components.tasklistsubtitle

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.homemanagement.ui.theme.AppTheme
import com.martamazurkozlowska.homemanagement.ui.theme.AppTypography

@Composable
fun TaskListSubtitleView(
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(vertical = 16.dp)
    ) {
        Text(
            text = subtitle.uppercase(),
            style = AppTypography.bodySmallBlack,
        )

        Spacer(
            modifier = Modifier.width(8.dp)
        )

        HorizontalDivider(
            thickness = 1.dp,
            )
    }
}

@Preview
@Composable
fun TaskListSubtitleViewPreview() = AppTheme {
    TaskListSubtitleView(
        subtitle = "Tasks for today"
    )
}