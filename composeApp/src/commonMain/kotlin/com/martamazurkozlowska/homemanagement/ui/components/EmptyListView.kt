package com.martamazurkozlowska.homemanagement.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.homemanagement.ui.theme.AppColors
import com.martamazurkozlowska.homemanagement.ui.theme.AppTheme
import com.martamazurkozlowska.homemanagement.ui.theme.AppTypography
import homemanagement.composeapp.generated.resources.Res
import homemanagement.composeapp.generated.resources.empty_list_view_1
import homemanagement.composeapp.generated.resources.empty_list_view_2
import homemanagement.composeapp.generated.resources.empty_list_view_3
import org.jetbrains.compose.resources.stringResource

@Composable
fun EmptyListView(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 80.dp, start = 24.dp, end = 24.dp)
    ) {
        Text(
            buildAnnotatedString {
                append(stringResource(Res.string.empty_list_view_1))
                withStyle(style = SpanStyle(color = AppColors.green500)) {
                    append(stringResource(Res.string.empty_list_view_2))
                }
                append(stringResource(Res.string.empty_list_view_3))
            },
            style = AppTypography.h3Bold,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
private fun EmptyListViewPreview() = AppTheme {
    EmptyListView()
}

