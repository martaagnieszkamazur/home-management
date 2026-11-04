package com.martamazurkozlowska.homemanagement.app

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import com.martamazurkozlowska.homemanagement.ui.components.taskitem.TaskItemUiModel
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

object Route {

    @Serializable
    object Main : NavKey

    @Serializable
    object TaskList : NavKey

    @Serializable
    object AddTask : NavKey

    @Serializable
    object Settings : NavKey

    @Serializable
    object Import : NavKey

    @Serializable
    object Export : NavKey

    @Serializable
    data class Edit(val task: TaskItemUiModel): NavKey

    val config = SavedStateConfiguration {
        serializersModule = SerializersModule {
            polymorphic(NavKey::class) {
                subclass(Main::class, Main.serializer())
                subclass(TaskList::class, TaskList.serializer())
                subclass(AddTask::class, AddTask.serializer())
                subclass(Settings::class, Settings.serializer())
                subclass(Import::class, Import.serializer())
                subclass(Export::class, Export.serializer())
                subclass(Edit::class, Edit.serializer())
            }
        }
    }
}