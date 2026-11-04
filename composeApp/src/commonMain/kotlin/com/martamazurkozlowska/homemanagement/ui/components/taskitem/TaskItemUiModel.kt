package com.martamazurkozlowska.homemanagement.ui.components.taskitem

import com.martamazurkozlowska.homemanagement.ui.taskcategory.BaseTaskListItemUiModel
import kotlinx.serialization.Serializable

@Serializable
data class TaskItemUiModel(
    val name: String,
    val remainingDays: Int,
    val creationTimestampInSeconds: Long,
    val timePeriodInSeconds: Long,
    val completed: Boolean,
    val color: TaskItemColorUiModel,
    val notes: String,
) : BaseTaskListItemUiModel