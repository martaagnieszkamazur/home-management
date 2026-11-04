package com.martamazurkozlowska.homemanagement.app.settings.importjson

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martamazurkozlowska.homemanagement.storage.TaskListStorageManager
import kotlinx.coroutines.launch

class ImportViewModel(
    private val storageManager: TaskListStorageManager,
) : ViewModel() {

    val jsonTextFieldState = TextFieldState()

    fun onImportClick() {
        viewModelScope.launch {
            storageManager.setTaskList(jsonTextFieldState.text.toString())
        }
    }
}