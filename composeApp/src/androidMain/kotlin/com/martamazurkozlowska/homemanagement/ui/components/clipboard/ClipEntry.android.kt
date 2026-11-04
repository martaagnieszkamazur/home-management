package com.martamazurkozlowska.homemanagement.ui.components.clipboard

import android.content.ClipData
import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.platform.toClipEntry

actual fun getClipEntry(text: String): ClipEntry =
    ClipData.newPlainText(text, text).toClipEntry()