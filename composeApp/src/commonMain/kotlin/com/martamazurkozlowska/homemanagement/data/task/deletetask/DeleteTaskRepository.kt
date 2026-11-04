package com.martamazurkozlowska.homemanagement.data.task.deletetask

import com.martamazurkozlowska.homemanagement.data.task.TaskItemApiModel
import com.martamazurkozlowska.homemanagement.data.task.toApiModel
import com.martamazurkozlowska.homemanagement.storage.TaskListStorageManager
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemUiModel
import kotlinx.serialization.json.Json

class DeleteTaskRepository(
    private val storageManager: TaskListStorageManager,
) {
    suspend fun deleteTask(
        existingTask: TaskItemUiModel,
        taskList: List<TaskItemUiModel>,
    ) {
        val editedTaskList: MutableList<TaskItemApiModel> =
            taskList.map { it.toApiModel() }.toMutableList()
        val deletedTask: TaskItemApiModel = existingTask.toApiModel()
        editedTaskList.remove(deletedTask)
        val json = Json.encodeToString(editedTaskList)
        storageManager.setTaskList(json)
    }
}