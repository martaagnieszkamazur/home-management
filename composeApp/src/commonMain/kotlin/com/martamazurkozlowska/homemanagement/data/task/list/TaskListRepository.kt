package com.martamazurkozlowska.homemanagement.data.task.list

import com.martamazurkozlowska.homemanagement.data.task.TaskItemApiModel
import com.martamazurkozlowska.homemanagement.data.task.toApiModel
import com.martamazurkozlowska.homemanagement.data.task.toUiModel
import com.martamazurkozlowska.homemanagement.storage.TaskListStorageManager
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json

class TaskListRepository(
    private val storageManager: TaskListStorageManager,
) {

    private val prettyJson = Json { prettyPrint = true }

    fun getTaskList(): Flow<List<TaskItemUiModel>> =
        storageManager.getTaskListJson().map {
            try {
                Json.decodeFromString<List<TaskItemApiModel>>(it).map { it.toUiModel() }
            } catch (exception: Exception) {
                exception.printStackTrace()
                emptyList()
            }
        }

    fun getTaskListJson(): Flow<String> = storageManager.getTaskListJson().map {
        try {
            Json.decodeFromString<List<TaskItemApiModel>>(it).toFormattedJson()
        } catch (exception: Exception){
            exception.printStackTrace()
            "[]"
        }
    }

    private fun List<TaskItemApiModel>.toFormattedJson(): String = try {
        prettyJson.encodeToString(this)
    } catch (exception: Exception) {
        exception.printStackTrace()
        "[]"
    }

    suspend fun setTaskList(list: List<TaskItemUiModel>) {
        val apiModelList = list.map { it.toApiModel() }
        val json = Json.encodeToString(apiModelList)
        println(prettyJson.encodeToString(apiModelList))
        storageManager.setTaskList(json)
    }
}