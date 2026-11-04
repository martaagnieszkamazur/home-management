package com.martamazurkozlowska.homemanagement.ui.components.clipboard

import androidx.compose.ui.platform.Clipboard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun copyToClipboard(coroutineScope: CoroutineScope, clipboard: Clipboard, text: String) {
    coroutineScope.launch {
        clipboard.setClipEntry(
            clipEntry = getClipEntry(text)
        )
    }
}