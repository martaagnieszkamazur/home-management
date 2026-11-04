package com.martamazurkozlowska.homemanagement.di

import com.martamazurkozlowska.homemanagement.app.addtask.AddTaskViewModel
import com.martamazurkozlowska.homemanagement.app.edittask.EditTaskViewModel
import com.martamazurkozlowska.homemanagement.app.settings.exportjson.ExportViewModel
import com.martamazurkozlowska.homemanagement.app.settings.importjson.ImportViewModel
import com.martamazurkozlowska.homemanagement.app.tasklist.TaskListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::TaskListViewModel)
    viewModelOf(::AddTaskViewModel)
    viewModelOf(::ImportViewModel)
    viewModelOf(::ExportViewModel)
    viewModelOf(::EditTaskViewModel)
}