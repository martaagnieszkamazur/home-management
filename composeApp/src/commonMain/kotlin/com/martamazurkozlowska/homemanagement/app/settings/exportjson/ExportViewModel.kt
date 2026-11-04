package com.martamazurkozlowska.homemanagement.app.settings.exportjson

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martamazurkozlowska.homemanagement.data.task.list.TaskListRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class ExportViewModel(
    private val repository: TaskListRepository,
) : ViewModel() {

    val jsonFlow: StateFlow<String> = repository.getTaskListJson().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = "",
    )
}