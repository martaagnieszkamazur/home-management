package com.martamazurkozlowska.homemanagement.app.tasklist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemUiModel
import com.martamazurkozlowska.homemanagement.ui.view.tasklist.TaskListView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TaskListScreen(
    viewModel: TaskListViewModel = koinViewModel(),
    onSettingsClick: () -> Unit,
    onEditTaskClick: (task: TaskItemUiModel) -> Unit,
    onAddTaskClick: () -> Unit,
) {
    val viewState by viewModel.viewStateFlow.collectAsStateWithLifecycle()
    TaskListView(
        viewState = viewState,
        onSettingsClick = onSettingsClick,
        onEditTaskClick = onEditTaskClick,
        onCompleteClick = viewModel::onCompleteClick,
        onAddTaskClick = onAddTaskClick,
    )
}
