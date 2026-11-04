package com.martamazurkozlowska.homemanagement.app.edittask

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martamazurkozlowska.homemanagement.data.task.deletetask.DeleteTaskRepository
import com.martamazurkozlowska.homemanagement.data.task.edittask.EditTaskRepository
import com.martamazurkozlowska.homemanagement.data.task.list.TaskListRepository
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemColorUiModel
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class EditTaskViewModel(
    private val repository: EditTaskRepository,
    private val deleteTaskRepository: DeleteTaskRepository,
    private val taskListRepository: TaskListRepository,
) : ViewModel() {
    val nameTextState = TextFieldState()

    private val taskNameError = MutableStateFlow<Boolean>(false)
    val taskNameErrorFlow = taskNameError.asStateFlow()

    val timePeriodTextState = TextFieldState()

    private val timePeriodError = MutableStateFlow<Boolean>(false)
    val timePeriodErrorFlow = timePeriodError.asStateFlow()

    private val selectedColor = MutableStateFlow<TaskItemColorUiModel>(TaskItemColorUiModel.Green)
    val selectedColorFlow = selectedColor.asStateFlow()

    val notesTextState = TextFieldState()

    val taskListFlow: StateFlow<List<TaskItemUiModel>> = taskListRepository.getTaskList().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )

    private lateinit var existingTask: TaskItemUiModel

    private val viewAction = MutableStateFlow<EditTaskViewAction?>(null)
    val viewActionFlow = viewAction.asStateFlow()

    fun init(task: TaskItemUiModel) {
        existingTask = task
        nameTextState.edit {
            append(text = task.name)
        }
        timePeriodTextState.edit {
            append(text = task.remainingDays.toString())
        }
        selectedColor.value = task.color
        notesTextState.edit {
            append(text = task.notes)
        }
    }

    fun onColorClick(color: TaskItemColorUiModel) {
        selectedColor.value = color
    }

    fun onSaveTaskClick() {
        viewModelScope.launch {
            taskNameError.value = nameTextState.text.isBlank()
            timePeriodError.value = timePeriodTextState.text.isBlank()
            timePeriodError.value = timePeriodTextState.text.toString().toLongOrNull() == null

            if (!taskNameError.value && !timePeriodError.value) {
                repository.editTask(
                    existingTask = existingTask,
                    taskList = taskListFlow.value,
                    name = nameTextState.text.toString(),
                    timePeriodInSeconds = getTimePeriodInSeconds(),
                    color = selectedColor.value,
                    notes = notesTextState.text.toString(),
                )
                viewAction.value = EditTaskViewAction.GoBack
            }
        }
    }

    fun onDeleteTaskClick() {
        viewModelScope.launch {
            deleteTaskRepository.deleteTask(
                existingTask = existingTask,
                taskList = taskListFlow.value,
            )
        }
    }

    fun onViewActionHandled() {
        viewAction.value = null
    }

    private fun getTimePeriodInSeconds(): Long {
        return timePeriodTextState.text.toString().toLong() * SECONDS_IN_DAY
    }

    companion object {
        private const val SECONDS_IN_DAY = 24 * 60 * 60
    }
}