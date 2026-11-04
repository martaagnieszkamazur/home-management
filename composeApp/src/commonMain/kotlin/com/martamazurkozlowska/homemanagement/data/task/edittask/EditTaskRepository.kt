package com.martamazurkozlowska.homemanagement.data.task.edittask

import com.martamazurkozlowska.homemanagement.data.task.TaskItemApiModel
import com.martamazurkozlowska.homemanagement.data.task.toApiModel
import com.martamazurkozlowska.homemanagement.storage.TaskListStorageManager
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemColorUiModel
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemUiModel
import kotlinx.serialization.json.Json

class EditTaskRepository(
    private val storageManager: TaskListStorageManager,
) {
    suspend fun editTask(
        existingTask: TaskItemUiModel,
        taskList: List<TaskItemUiModel>,
        name: String,
        timePeriodInSeconds: Long,
        color: TaskItemColorUiModel,
        notes: String,
    ) {
        val editedTaskList: MutableList<TaskItemApiModel> =
            taskList.map { it.toApiModel() }.toMutableList()
        val existingTaskApiModel = existingTask.toApiModel()
        val newTask: TaskItemApiModel = existingTaskApiModel.copy(
            name = name,
            timePeriodInSeconds = timePeriodInSeconds,
            color = color.name,
            notes = notes,
        )
        editedTaskList.remove(existingTaskApiModel)
        editedTaskList.add(newTask)
        val json = Json.encodeToString(editedTaskList)
        storageManager.setTaskList(json)
    }
}