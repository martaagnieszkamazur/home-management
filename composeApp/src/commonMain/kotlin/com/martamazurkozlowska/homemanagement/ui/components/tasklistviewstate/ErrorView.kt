package com.martamazurkozlowska.homemanagement.ui.components.tasklistviewstate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.homemanagement.ui.theme.AppTheme
import com.martamazurkozlowska.homemanagement.ui.theme.AppTypography
import homemanagement.composeapp.generated.resources.Res
import homemanagement.composeapp.generated.resources.error_view
import org.jetbrains.compose.resources.stringResource

@Composable
fun ErrorView(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 80.dp, start = 24.dp, end = 24.dp)
    ) {
        Text(
            text = stringResource(Res.string.error_view),
            style = AppTypography.h3Bold,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
private fun ErrorViewPreview() = AppTheme {
    ErrorView()
}