package com.martamazurkozlowska.homemanagement.app

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.martamazurkozlowska.homemanagement.app.addtask.AddTaskScreen
import com.martamazurkozlowska.homemanagement.app.edittask.EditTaskScreen
import com.martamazurkozlowska.homemanagement.app.settings.SettingsScreen
import com.martamazurkozlowska.homemanagement.app.settings.exportjson.ExportScreen
import com.martamazurkozlowska.homemanagement.app.settings.importjson.ImportScreen
import com.martamazurkozlowska.homemanagement.app.tasklist.TaskListScreen

@Composable
fun MainNavigationScreen() {
    val backStack = rememberNavBackStack(Route.config, Route.TaskList)

    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        entryProvider = entryProvider {
            entry<Route.Main> {
                MainNavigationScreen()
            }

            entry<Route.TaskList> {
                TaskListScreen(
                    onSettingsClick = {
                        backStack.add(Route.Settings)
                    },
                    onEditTaskClick = {
                        backStack.add(Route.Edit(it))
                    },
                    onAddTaskClick = {
                        backStack.add(Route.AddTask)
                    },
                )
            }

            entry<Route.AddTask> {
                AddTaskScreen(
                    onBackClick = {
                        backStack.removeLastOrNull()
                    }
                )
            }

            entry<Route.Settings> {
                SettingsScreen(
                    onBackClick = {
                        backStack.removeLastOrNull()
                    },
                    onImportTasksClick = {
                        backStack.add(Route.Import)
                    },
                    onExportTasksClick = {
                        backStack.add(Route.Export)
                    }
                )
            }

            entry<Route.Import> {
                ImportScreen(
                    onBackClick = {
                        backStack.removeLastOrNull()
                    }
                )
            }

            entry<Route.Export> {
                ExportScreen(
                    onBackClick = {
                        backStack.removeLastOrNull()
                    }
                )
            }

            entry<Route.Edit> {
                EditTaskScreen(
                    existingTask = it.task,
                    onBackClick = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        }
    )
}