package com.martamazurkozlowska.homemanagement.di

import com.martamazurkozlowska.homemanagement.data.task.addtask.AddTaskRepository
import com.martamazurkozlowska.homemanagement.data.task.deletetask.DeleteTaskRepository
import com.martamazurkozlowska.homemanagement.data.task.edittask.EditTaskRepository
import com.martamazurkozlowska.homemanagement.data.task.list.TaskListRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    factoryOf(::AddTaskRepository)
    factoryOf(::TaskListRepository)
    factoryOf(::EditTaskRepository)
    factoryOf(::DeleteTaskRepository)
}