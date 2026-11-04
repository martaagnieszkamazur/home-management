package com.martamazurkozlowska.homemanagement.di

import com.martamazurkozlowska.homemanagement.storage.createDataStore
import org.koin.dsl.module

actual val dataStoreModule = module {
    single { createDataStore(context = get()) }
}