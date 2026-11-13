package com.martamazurkozlowska.homemanagement.data.task.list

import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemUiModel

sealed interface TaskListDataResult {
    data class Success(val taskList: List<TaskItemUiModel>) : TaskListDataResult

    object Error : TaskListDataResult
}