package com.martamazurkozlowska.homemanagement.app.tasklist

import com.martamazurkozlowska.homemanagement.ui.taskcategory.BaseTaskListItemUiModel

sealed class TaskListViewState {

    data class Content(
        val taskList: List<BaseTaskListItemUiModel>
    ) : TaskListViewState()

    object Empty : TaskListViewState()
}

