package com.martamazurkozlowska.homemanagement.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalAppTypography = staticCompositionLocalOf { Typography() }

val AppTypography: Typography
    @Composable
    get() = LocalAppTypography.current

private val MaterialColorScheme = lightColorScheme(
    primary = AppColors.greenPrimary,
    secondary = AppColors.bluePrimary,
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    val typography = createTypography()
    CompositionLocalProvider(LocalAppTypography provides typography) {
        MaterialTheme(
            colorScheme = MaterialColorScheme,
            content = content,
        )
    }
}