package com.martamazurkozlowska.homemanagement

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.martamazurkozlowska.homemanagement.app.MainNavigationScreen
import com.martamazurkozlowska.homemanagement.di.appModule
import com.martamazurkozlowska.homemanagement.di.dataModule
import com.martamazurkozlowska.homemanagement.di.dataStoreModule
import com.martamazurkozlowska.homemanagement.di.storageModule
import com.martamazurkozlowska.homemanagement.ui.theme.AppTheme
import org.koin.compose.KoinApplication
import org.koin.dsl.koinConfiguration

@Composable
@Preview
fun App() {
    KoinApplication(
        configuration = koinConfiguration {
            modules(appModule, dataModule, storageModule, dataStoreModule)
        }
    ) {
        AppTheme {
            MainNavigationScreen()
        }
    }
}