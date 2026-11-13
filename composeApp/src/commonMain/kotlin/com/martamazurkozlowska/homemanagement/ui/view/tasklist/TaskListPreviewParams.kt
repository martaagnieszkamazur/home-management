package com.martamazurkozlowska.homemanagement.ui.view.tasklist

import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemColorUiModel
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemUiModel
import com.martamazurkozlowska.homemanagement.ui.taskcategory.TaskCategoryUiModel

fun mockedTaskList() =listOf(
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