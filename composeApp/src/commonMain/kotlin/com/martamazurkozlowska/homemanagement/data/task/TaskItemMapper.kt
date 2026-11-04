package com.martamazurkozlowska.homemanagement.data.task

import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemColorUiModel
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemUiModel
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.Instant

fun TaskItemUiModel.toApiModel() =
    TaskItemApiModel(
        name = name,
        timePeriodInSeconds = timePeriodInSeconds,
        creationTimestampInSeconds = creationTimestampInSeconds,
        color = color.name,
        completed = completed,
        notes = notes,
    )

fun TaskItemApiModel.toUiModel() = TaskItemUiModel(
    name = name,
    remainingDays = getRemainingDays(),
    timePeriodInSeconds = timePeriodInSeconds,
    creationTimestampInSeconds = creationTimestampInSeconds,
    completed = completed,
    color = this.color.toColorUiModel(),
    notes = notes,
)

private fun TaskItemApiModel.getRemainingDays(): Int {
    val currentDate = Clock.System.now().toLocalDateTime(timeZone = TimeZone.UTC).date
    val dueDate = Instant.fromEpochSeconds(creationTimestampInSeconds + timePeriodInSeconds)
        .toLocalDateTime(timeZone = TimeZone.UTC).date
    return currentDate.daysUntil(dueDate)
}

private fun String.toColorUiModel() = when (this) {
    "Green" -> TaskItemColorUiModel.Green
    "Blue" -> TaskItemColorUiModel.Blue
    "Yellow" -> TaskItemColorUiModel.Yellow
    "Purple" -> TaskItemColorUiModel.Purple
    "Orange" -> TaskItemColorUiModel.Orange
    else -> TaskItemColorUiModel.Green
}