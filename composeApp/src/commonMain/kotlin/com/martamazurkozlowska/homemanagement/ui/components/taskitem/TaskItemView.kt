package com.martamazurkozlowska.homemanagement.ui.components.taskitem

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.homemanagement.ui.theme.AppColors
import com.martamazurkozlowska.homemanagement.ui.theme.AppShapes
import com.martamazurkozlowska.homemanagement.ui.theme.AppTheme
import com.martamazurkozlowska.homemanagement.ui.theme.AppTypography
import homemanagement.composeapp.generated.resources.Res
import homemanagement.composeapp.generated.resources.ic_completed
import org.jetbrains.compose.resources.painterResource

@Composable
fun TaskItemView(
    task: TaskItemUiModel,
    onEditTaskClick: (task: TaskItemUiModel) -> Unit,
    onCompleteClick: (task: TaskItemUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .backgroundEffect(task = task)
            .clip(AppShapes.taskItem)
            .combinedClickable(
                onClick = { onEditTaskClick(task) },
                onLongClick = {},
            )
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = task.name,
                style = AppTypography.h3Bold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "${task.remainingDays} days remaining",
                style = AppTypography.bodySmallLight,
            )
        }

        Spacer(
            modifier = Modifier.width(16.dp)
        )

        Icon(
            painter = painterResource(Res.drawable.ic_completed),
            contentDescription = null,
            tint = if (task.completed) {
                task.color.secondaryColor
            } else {
                AppColors.gray50
            },
            modifier = Modifier
                .background(
                    color = if (task.completed) {
                        AppColors.gray50
                    } else {
                        task.color.primaryColor
                    },
                    shape = CircleShape
                )
                .size(36.dp)
                .clip(CircleShape)
                .clickable(onClick = { onCompleteClick(task) })
                .padding(8.dp)
        )
    }
}

@Composable
private fun Modifier.backgroundEffect(task: TaskItemUiModel): Modifier {
    val firstColor by animateColorAsState(
        targetValue = if (task.completed) {
            task.color.tertiaryColor
        } else {
            AppColors.gray50
        },
        animationSpec = tween(durationMillis = 500),
    )

    val secondColor by animateColorAsState(
        targetValue = if (task.completed) {
            task.color.primaryColor
        } else {
            AppColors.gray50
        },
        animationSpec = tween(durationMillis = 500),
    )

    return this.background(
        brush = Brush.linearGradient(
            colors = listOf(
                firstColor,
                secondColor,
            ),
            start = Offset(0.0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0.0f)
        ),
        shape = AppShapes.taskItem
    )
}

@Preview
@Composable
private fun TaskItemViewPreview() = AppTheme {
    TaskItemView(
        task = TaskItemUiModel(
            name = "Water monstera",
            remainingDays = 10,
            creationTimestampInSeconds = 222,
            timePeriodInSeconds = 222,
            completed = true,
            color = TaskItemColorUiModel.Yellow,
            notes = "",
        ),
        onEditTaskClick = {},
        onCompleteClick = {},
    )
}