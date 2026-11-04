package com.martamazurkozlowska.homemanagement.data.task.addtask

import com.martamazurkozlowska.homemanagement.data.task.TaskItemApiModel
import com.martamazurkozlowska.homemanagement.data.task.toApiModel
import com.martamazurkozlowska.homemanagement.storage.TaskListStorageManager
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemColorUiModel
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemUiModel
import kotlinx.serialization.json.Json
import kotlin.time.Clock

class AddTaskRepository(
    private val storageManager: TaskListStorageManager,
) {
    suspend fun saveTask(
        taskList: List<TaskItemUiModel>,
        name: String,
        timePeriodInSeconds: Long,
        color: TaskItemColorUiModel,
        completed: Boolean,
        notes: String,
    ) {
        val existingTaskList: List<TaskItemApiModel> = taskList.map { it.toApiModel() }
        val newTask = TaskItemApiModel(
            name = name,
            timePeriodInSeconds = timePeriodInSeconds,
            creationTimestampInSeconds = Clock.System.now().epochSeconds,
            color = color.name,
            completed = completed,
            notes = notes,
        )
        val newTaskList = existingTaskList.toMutableList()
        newTaskList.add(newTask)
        val json = Json.encodeToString(newTaskList)
        storageManager.setTaskList(json)
    }
}