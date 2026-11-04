package com.martamazurkozlowska.homemanagement.app.settings.exportjson

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalClipboard
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.martamazurkozlowska.homemanagement.ui.components.clipboard.copyToClipboard
import com.martamazurkozlowska.homemanagement.ui.view.export.ExportView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ExportScreen(
    viewModel: ExportViewModel = koinViewModel(),
    onBackClick: () -> Unit,
) {
    val json by viewModel.jsonFlow.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()
    val clipboard = LocalClipboard.current

    ExportView(
        json = json,
        onBackClick = onBackClick,
        onExportClick = {
            copyToClipboard(
                coroutineScope = coroutineScope,
                clipboard = clipboard,
                text = json
            )
        },
    )
}