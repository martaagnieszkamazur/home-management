package com.martamazurkozlowska.homemanagement.app.addtask

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.martamazurkozlowska.homemanagement.ui.view.addtask.AddTaskView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AddTaskScreen(
    viewModel: AddTaskViewModel = koinViewModel(),
    onBackClick: () -> Unit,
) {
    val selectedColor by viewModel.selectedColorFlow.collectAsStateWithLifecycle()
    val isTaskNameEmpty by viewModel.taskNameErrorFlow.collectAsStateWithLifecycle()
    val isTimePeriodEmpty by viewModel.timePeriodErrorFlow.collectAsStateWithLifecycle()
    val viewAction by viewModel.viewActionFlow.collectAsStateWithLifecycle()

    OnViewAction(
        viewAction = viewAction,
        goBack = onBackClick,
        onViewActionHandled = viewModel::onViewActionHandled
    )

    AddTaskView(
        name = viewModel.nameTextState,
        isTaskNameEmpty = isTaskNameEmpty,
        timePeriod = viewModel.timePeriodTextState,
        isTimePeriodEmpty = isTimePeriodEmpty,
        selectedColor = selectedColor,
        notes = viewModel.notesTextState,
        onBackClick = onBackClick,
        onColorClick = viewModel::onColorClick,
        onSaveTaskClick = viewModel::onSaveTaskClick
    )
}

@Composable
private fun OnViewAction(
    viewAction: AddTaskViewAction?,
    goBack: () -> Unit,
    onViewActionHandled: () -> Unit,
) {
    when (viewAction) {
        AddTaskViewAction.GoBack -> goBack()
        null -> return
    }

    onViewActionHandled()
}