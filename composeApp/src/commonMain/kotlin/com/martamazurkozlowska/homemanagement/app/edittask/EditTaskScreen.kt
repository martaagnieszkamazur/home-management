package com.martamazurkozlowska.homemanagement.app.edittask

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemUiModel
import com.martamazurkozlowska.homemanagement.ui.view.edittask.EditTaskView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun EditTaskScreen(
    viewModel: EditTaskViewModel = koinViewModel(),
    existingTask: TaskItemUiModel,
    onBackClick: () -> Unit,
) {
    val selectedColor by viewModel.selectedColorFlow.collectAsStateWithLifecycle()
    val isTaskNameEmpty by viewModel.taskNameErrorFlow.collectAsStateWithLifecycle()
    val isTimePeriodEmpty by viewModel.timePeriodErrorFlow.collectAsStateWithLifecycle()
    val viewAction by viewModel.viewActionFlow.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.init(existingTask)
    }

    OnViewAction(
        viewAction = viewAction,
        goBack = onBackClick,
        onViewActionHandled = viewModel::onViewActionHandled
    )

    EditTaskView(
        name = viewModel.nameTextState,
        isTaskNameEmpty = isTaskNameEmpty,
        timePeriod = viewModel.timePeriodTextState,
        isTimePeriodEmpty = isTimePeriodEmpty,
        selectedColor = selectedColor,
        notes = viewModel.notesTextState,
        onBackClick = onBackClick,
        onColorClick = viewModel::onColorClick,
        onDeleteTaskClick = {
            viewModel.onDeleteTaskClick()
            onBackClick()
        },
        onSaveTaskClick = viewModel::onSaveTaskClick,
    )
}

@Composable
private fun OnViewAction(
    viewAction: EditTaskViewAction?,
    goBack: () -> Unit,
    onViewActionHandled: () -> Unit,
) {
    when (viewAction) {
        EditTaskViewAction.GoBack -> goBack()
        null -> return
    }

    onViewActionHandled()
}