package com.martamazurkozlowska.homemanagement.app.settings

import androidx.compose.runtime.Composable
import com.martamazurkozlowska.homemanagement.ui.view.settings.SettingsView

@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    onImportTasksClick: () -> Unit,
    onExportTasksClick: () -> Unit,
) {
    SettingsView(
        onBackClick = onBackClick,
        onImportTasksClick = onImportTasksClick,
        onExportTasksClick = onExportTasksClick,
    )
}