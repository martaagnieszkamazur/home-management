package com.martamazurkozlowska.homemanagement.ui.view.tasklist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.homemanagement.app.tasklist.TaskListViewState
import com.martamazurkozlowska.homemanagement.ui.components.EmptyListView
import com.martamazurkozlowska.homemanagement.ui.components.button.PrimaryButton
import com.martamazurkozlowska.homemanagement.ui.components.navigationbar.NavigationBar
import com.martamazurkozlowska.homemanagement.ui.components.statusbar.StatusBar
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemColorUiModel
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemUiModel
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemView
import com.martamazurkozlowska.homemanagement.ui.components.tasklistsubtitle.TaskListSubtitleView
import com.martamazurkozlowska.homemanagement.ui.components.topappbar.TopAppBarView
import com.martamazurkozlowska.homemanagement.ui.taskcategory.BaseTaskListItemUiModel
import com.martamazurkozlowska.homemanagement.ui.taskcategory.TaskCategoryUiModel
import com.martamazurkozlowska.homemanagement.ui.theme.AppColors
import com.martamazurkozlowska.homemanagement.ui.theme.AppTheme
import homemanagement.composeapp.generated.resources.Res
import homemanagement.composeapp.generated.resources.add_task
import homemanagement.composeapp.generated.resources.home_taskido
import homemanagement.composeapp.generated.resources.ic_add
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TaskListView(
    viewState: TaskListViewState,
    onSettingsClick: () -> Unit,
    onEditTaskClick: (task: TaskItemUiModel) -> Unit,
    onCompleteClick: (task: TaskItemUiModel) -> Unit,
    onAddTaskClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.background)
    ) {
        StatusBar()

        TopAppBarView(
            text = stringResource(Res.string.home_taskido),
            onSettingsClick = onSettingsClick,
        )

        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                when (viewState) {
                    is TaskListViewState.Empty -> EmptyListView()
                    is TaskListViewState.Content -> ListView(
                        items = viewState.taskList,
                        onEditTaskClick = onEditTaskClick,
                        onCompleteClick = onCompleteClick,
                    )
                }

                PrimaryButton(
                    text = stringResource(Res.string.add_task),
                    icon = painterResource(Res.drawable.ic_add),
                    onClick = onAddTaskClick,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 16.dp)
                )
            }

            NavigationBar()
        }

    }
}

@Composable
private fun ListView(
    items: List<BaseTaskListItemUiModel>,
    onEditTaskClick: (task: TaskItemUiModel) -> Unit,
    onCompleteClick: (task: TaskItemUiModel) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(items = items) {
            when (it) {
                is TaskItemUiModel -> TaskItemView(
                    task = it,
                    onEditTaskClick = onEditTaskClick,
                    onCompleteClick = onCompleteClick
                )

                is TaskCategoryUiModel -> TaskListSubtitleView(
                    subtitle = it.title
                )
            }
        }
    }
}

@Preview
@Composable
private fun TaskListViewPreview() = AppTheme {
    TaskListView(
        viewState = TaskListViewState.Content(
            listOf(
                TaskCategoryUiModel(
                    title = "Tasks for today"
                ),
                TaskItemUiModel(
                    name = "Water monstera",
                    remainingDays = 3,
                    creationTimestampInSeconds = 11,
                    timePeriodInSeconds = 11,
                    completed = false,
                    color = TaskItemColorUiModel.Green,
                    notes = "",
                ),
                TaskItemUiModel(
                    name = "Water zamio",
                    remainingDays = 0,
                    creationTimestampInSeconds = 22,
                    timePeriodInSeconds = 22,
                    completed = true,
                    color = TaskItemColorUiModel.Green,
                    notes = "",
                ),
                TaskItemUiModel(
                    name = "Clean office",
                    remainingDays = 5,
                    creationTimestampInSeconds = 33,
                    timePeriodInSeconds = 33,
                    completed = true,
                    color = TaskItemColorUiModel.Blue,
                    notes = "",
                ),
                TaskItemUiModel(
                    name = "Clean bathroom",
                    remainingDays = 2,
                    creationTimestampInSeconds = 44,
                    timePeriodInSeconds = 44,
                    completed = false,
                    color = TaskItemColorUiModel.Blue,
                    notes = "",
                ),
                TaskItemUiModel(
                    name = "Fix the sockets",
                    remainingDays = 8,
                    creationTimestampInSeconds = 55,
                    timePeriodInSeconds = 55,
                    completed = false,
                    color = TaskItemColorUiModel.Purple,
                    notes = "",
                ),
                TaskItemUiModel(
                    name = "Water monstera",
                    remainingDays = 3,
                    creationTimestampInSeconds = 66,
                    timePeriodInSeconds = 66,
                    completed = false,
                    color = TaskItemColorUiModel.Green,
                    notes = "",
                ),
                TaskItemUiModel(
                    name = "Water zamio",
                    remainingDays = 0,
                    creationTimestampInSeconds = 77,
                    timePeriodInSeconds = 77,
                    completed = true,
                    color = TaskItemColorUiModel.Orange,
                    notes = "",
                ),
                TaskItemUiModel(
                    name = "Clean office",
                    remainingDays = 5,
                    creationTimestampInSeconds = 88,
                    timePeriodInSeconds = 88,
                    completed = true,
                    color = TaskItemColorUiModel.Yellow,
                    notes = "",
                ),
                TaskItemUiModel(
                    name = "Clean bathroom",
                    remainingDays = 2,
                    creationTimestampInSeconds = 99,
                    timePeriodInSeconds = 99,
                    completed = false,
                    color = TaskItemColorUiModel.Yellow,
                    notes = "",
                ),
                TaskItemUiModel(
                    name = "Fix the sockets",
                    remainingDays = 8,
                    creationTimestampInSeconds = 111,
                    timePeriodInSeconds = 111,
                    completed = false,
                    color = TaskItemColorUiModel.Purple,
                    notes = "",
                ),
            )
        ),
        onSettingsClick = {},
        onEditTaskClick = {},
        onCompleteClick = {},
        onAddTaskClick = {},
    )
}