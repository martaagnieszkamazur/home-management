package com.martamazurkozlowska.homemanagement.di

import com.martamazurkozlowska.homemanagement.storage.TaskListStorageManager
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

expect val dataStoreModule: Module

val storageModule = module {
    singleOf(::TaskListStorageManager)
}