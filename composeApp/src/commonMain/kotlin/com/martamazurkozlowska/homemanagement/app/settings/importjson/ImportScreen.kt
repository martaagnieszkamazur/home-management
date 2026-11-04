package com.martamazurkozlowska.homemanagement.app.settings.importjson

import androidx.compose.runtime.Composable
import com.martamazurkozlowska.homemanagement.ui.view.importjson.ImportJsonView
import multiplatform.network.cmptoast.showToast
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ImportScreen(
    viewModel: ImportViewModel = koinViewModel(),
    onBackClick: () -> Unit,
) {
    ImportJsonView(
        jsonTextFieldState = viewModel.jsonTextFieldState,
        onBackClick = onBackClick,
        onImportClick = {
            viewModel.onImportClick()
            showToast(
                message = "Tasks imported",
            )
            onBackClick()
        },
    )
}