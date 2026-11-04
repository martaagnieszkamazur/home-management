package com.martamazurkozlowska.homemanagement.app.tasklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martamazurkozlowska.homemanagement.data.task.list.TaskListRepository
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemUiModel
import com.martamazurkozlowska.homemanagement.ui.taskcategory.BaseTaskListItemUiModel
import com.martamazurkozlowska.homemanagement.ui.taskcategory.TaskCategoryUiModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskListViewModel(
    private val repository: TaskListRepository,
) : ViewModel() {

    private var taskList: List<TaskItemUiModel> = emptyList()

    val taskListFlow: StateFlow<List<BaseTaskListItemUiModel>> =
        repository.getTaskList().map { it.sortedBy { it.remainingDays } }.map {
            this.taskList = it
            getCategorizedItems(it)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = emptyList(),
        )

    fun onCompleteClick(task: TaskItemUiModel) {
        val list = taskList.toMutableList()
        list.remove(task)
        val newTask = task.copy(completed = !task.completed)
        list.add(newTask)
        viewModelScope.launch {
            repository.setTaskList(list)
        }
    }

    private fun getCategorizedItems(taskList: List<TaskItemUiModel>): List<BaseTaskListItemUiModel> {
        val result = mutableListOf<BaseTaskListItemUiModel>()

        addTasksWithCategory(
            remainingDays = IntRange(Int.MIN_VALUE, 0),
            taskList = taskList,
            result = result
        )

        addTasksWithCategory(
            remainingDays = IntRange(1, 1),
            taskList = taskList,
            result = result
        )

        addTasksWithCategory(
            remainingDays = IntRange(2, Int.MAX_VALUE),
            taskList = taskList,
            result = result
        )

        return result
    }

    private fun addTasksWithCategory(
        remainingDays: IntRange,
        taskList: List<TaskItemUiModel>,
        result: MutableList<BaseTaskListItemUiModel>,
    ) {
        val filteredTasks = taskList.filter {
            it.remainingDays >= remainingDays.first && it.remainingDays <= remainingDays.last
        }

        if (filteredTasks.isNotEmpty()) {
            result.add(
                TaskCategoryUiModel(
                    title = getCategoryTitle(remainingDays.last)
                )
            )
            result.addAll(filteredTasks)
        }
    }

    private fun getCategoryTitle(remainingDays: Int): String {
        return when (remainingDays) {
            0    -> "Tasks for today"
            1    -> "Tasks for tomorrow"
            else -> "Upcoming tasks"
        }
    }
}