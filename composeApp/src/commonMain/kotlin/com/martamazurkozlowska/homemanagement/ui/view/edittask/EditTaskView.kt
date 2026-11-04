package com.martamazurkozlowska.homemanagement.ui.view.edittask

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.homemanagement.ui.components.button.PrimaryButton
import com.martamazurkozlowska.homemanagement.ui.components.navigationbar.NavigationBar
import com.martamazurkozlowska.homemanagement.ui.components.statusbar.StatusBar
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemColorUiModel
import com.martamazurkozlowska.homemanagement.ui.components.topappbar.SecondaryTopAppBarView
import com.martamazurkozlowska.homemanagement.ui.theme.AppColors
import com.martamazurkozlowska.homemanagement.ui.theme.AppTheme
import com.martamazurkozlowska.homemanagement.ui.view.addtask.TaskFieldsView
import homemanagement.composeapp.generated.resources.Res
import homemanagement.composeapp.generated.resources.edit_task
import homemanagement.composeapp.generated.resources.ic_completed
import homemanagement.composeapp.generated.resources.ic_delete
import homemanagement.composeapp.generated.resources.save_task
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun EditTaskView(
    name: TextFieldState,
    isTaskNameEmpty: Boolean,
    timePeriod: TextFieldState,
    isTimePeriodEmpty: Boolean,
    selectedColor: TaskItemColorUiModel,
    notes: TextFieldState,
    onBackClick: () -> Unit,
    onColorClick: (TaskItemColorUiModel) -> Unit,
    onDeleteTaskClick: () -> Unit,
    onSaveTaskClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.background)
            .padding(16.dp)
    ) {
        StatusBar()

        SecondaryTopAppBarView(
            title = stringResource(Res.string.edit_task),
            icon = painterResource(Res.drawable.ic_delete),
            onBackClick = onBackClick,
            onIconClick = onDeleteTaskClick,
        )

        TaskFieldsView(
            name = name,
            isTaskNameEmpty = isTaskNameEmpty,
            timePeriod = timePeriod,
            isTimePeriodEmpty = isTimePeriodEmpty,
            selectedColor = selectedColor,
            onColorClick = onColorClick,
            notes = notes,
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        PrimaryButton(
            text = stringResource(Res.string.save_task),
            icon = painterResource(Res.drawable.ic_completed),
            onClick = onSaveTaskClick,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        )

        NavigationBar()
    }
}

@Preview
@Composable
private fun EditTaskViewPreview() = AppTheme {
    EditTaskView(
        name = TextFieldState(
            initialText = "Example"
        ),
        isTaskNameEmpty = false,
        timePeriod = TextFieldState(
            initialText = "3"
        ),
        isTimePeriodEmpty = false,
        selectedColor = TaskItemColorUiModel.Blue,
        notes = TextFieldState(
            initialText = ""
        ),
        onBackClick = {},
        onColorClick = {
            println(it)
        },
        onDeleteTaskClick = {},
        onSaveTaskClick = {},
    )
}