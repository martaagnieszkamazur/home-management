package com.martamazurkozlowska.homemanagement.ui.view.addtask

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.homemanagement.ui.components.modifier.clickableWithRoundedEffect
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemColorUiModel
import com.martamazurkozlowska.homemanagement.ui.theme.AppColors
import com.martamazurkozlowska.homemanagement.ui.theme.AppDimens
import com.martamazurkozlowska.homemanagement.ui.theme.AppShapes
import com.martamazurkozlowska.homemanagement.ui.theme.AppTypography
import homemanagement.composeapp.generated.resources.Res
import homemanagement.composeapp.generated.resources.ic_completed
import homemanagement.composeapp.generated.resources.notes
import homemanagement.composeapp.generated.resources.task_name
import homemanagement.composeapp.generated.resources.theme_color
import homemanagement.composeapp.generated.resources.time_period
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TaskFieldsView(
    name: TextFieldState,
    isTaskNameEmpty: Boolean,
    timePeriod: TextFieldState,
    isTimePeriodEmpty: Boolean,
    selectedColor: TaskItemColorUiModel,
    notes: TextFieldState,
    onColorClick: (TaskItemColorUiModel) -> Unit,
) {
    Spacer(
        modifier = Modifier.height(24.dp)
    )

    TaskNameTextFieldView(
        name = name,
        isError = isTaskNameEmpty,
    )

    Spacer(
        modifier = Modifier.height(36.dp)
    )

    TimePeriodTextFieldView(
        timePeriod = timePeriod,
        isError = isTimePeriodEmpty,
    )

    Spacer(
        modifier = Modifier.height(24.dp)
    )

    CategoryColorSelectorView(
        selectedColor = selectedColor,
        onColorClick = onColorClick
    )

    Spacer(
        modifier = Modifier.height(24.dp)
    )

    TaskNotesTextFieldView(
        notes = notes,
    )
}

@Composable
private fun TaskNameTextFieldView(
    name: TextFieldState,
    isError: Boolean,
) {
    Column {
        Text(
            text = stringResource(Res.string.task_name).uppercase(),
            style = AppTypography.bodySmallBlack,
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        TextField(
            state = name,
            shape = AppShapes.textField,
            colors = TextFieldDefaults.colors(
                focusedTextColor = AppColors.text,
                focusedContainerColor = AppColors.gray50,
                unfocusedContainerColor = AppColors.gray100,
                focusedIndicatorColor = AppColors.gray50,
                unfocusedIndicatorColor = AppColors.gray100,
                cursorColor = AppColors.green500,
            ),
            textStyle = AppTypography.bodyMediumRegular,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            isError = isError,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun TimePeriodTextFieldView(
    timePeriod: TextFieldState,
    isError: Boolean,
) {
    Column {
        Text(
            text = stringResource(Res.string.time_period).uppercase(),
            style = AppTypography.bodySmallBlack
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        TextField(
            state = timePeriod,
            shape = AppShapes.textField,
            colors = TextFieldDefaults.colors(
                focusedTextColor = AppColors.text,
                focusedContainerColor = AppColors.gray50,
                unfocusedContainerColor = AppColors.gray100,
                focusedIndicatorColor = AppColors.gray50,
                unfocusedIndicatorColor = AppColors.gray100,
                cursorColor = AppColors.green500,
            ),
            textStyle = AppTypography.bodyMediumRegular,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            lineLimits = TextFieldLineLimits.SingleLine,
            isError = isError,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun CategoryColorSelectorView(
    selectedColor: TaskItemColorUiModel,
    onColorClick: (TaskItemColorUiModel) -> Unit,
) {
    Column {
        Text(
            text = stringResource(Res.string.theme_color).uppercase(),
            style = AppTypography.bodySmallBlack,
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TaskItemColorUiModel.entries.forEach {
                ColorItemView(
                    color = it,
                    colorSelected = selectedColor == it,
                    onColorClick = onColorClick,
                )
            }
        }
    }
}

@Composable
private fun ColorItemView(
    color: TaskItemColorUiModel,
    colorSelected: Boolean,
    onColorClick: (TaskItemColorUiModel) -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clickableWithRoundedEffect(onClick = { onColorClick(color) })
            .border(
                width = if (colorSelected) 3.dp else 0.dp,
                color = if (colorSelected) color.primaryColor else AppColors.background,
                shape = AppShapes.pickColor
            )
            .padding(6.dp)
            .size(AppDimens.pickColorSize)
            .background(
                color = color.primaryColor,
                shape = AppShapes.pickColor
            )
    ) {
        if (colorSelected) {
            Icon(
                painter = painterResource(Res.drawable.ic_completed),
                contentDescription = null,
                tint = color.secondaryColor,
                modifier = Modifier
                    .size(AppDimens.iconSize)
            )
        }
    }
}

@Composable
private fun TaskNotesTextFieldView(
    notes: TextFieldState,
) {
    Column {
        Text(
            text = stringResource(Res.string.notes).uppercase(),
            style = AppTypography.bodySmallBlack
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        TextField(
            state = notes,
            shape = AppShapes.textField,
            colors = TextFieldDefaults.colors(
                focusedTextColor = AppColors.text,
                focusedContainerColor = AppColors.gray50,
                unfocusedContainerColor = AppColors.gray100,
                focusedIndicatorColor = AppColors.gray50,
                unfocusedIndicatorColor = AppColors.gray100,
                cursorColor = AppColors.green500,
            ),
            textStyle = AppTypography.bodyMediumRegular,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.None,
            ),
            lineLimits = TextFieldLineLimits.MultiLine(minHeightInLines = 5),
            modifier = Modifier.fillMaxWidth()
        )
    }
}