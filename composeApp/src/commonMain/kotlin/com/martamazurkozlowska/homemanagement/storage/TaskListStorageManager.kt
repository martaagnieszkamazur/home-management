package com.martamazurkozlowska.homemanagement.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskListStorageManager(
    private val dataStore: DataStore<Preferences>,
) {

    fun getTaskListJson(): Flow<String> = dataStore.data.map { it[key] ?: "[]" }

    suspend fun setTaskList(json: String) {
        dataStore.edit {
            it[key] = json
        }
    }

    companion object Companion {
        private val key = stringPreferencesKey("task_list")
    }
}