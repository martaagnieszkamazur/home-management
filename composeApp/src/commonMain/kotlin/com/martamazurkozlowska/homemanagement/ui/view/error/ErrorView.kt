package com.martamazurkozlowska.homemanagement.ui.view.error

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.homemanagement.ui.components.button.PrimaryButton
import com.martamazurkozlowska.homemanagement.ui.components.statusbar.StatusBar
import com.martamazurkozlowska.homemanagement.ui.theme.AppColors
import com.martamazurkozlowska.homemanagement.ui.theme.AppTheme
import com.martamazurkozlowska.homemanagement.ui.theme.AppTypography
import homemanagement.composeapp.generated.resources.Res
import homemanagement.composeapp.generated.resources.error
import homemanagement.composeapp.generated.resources.go_back
import homemanagement.composeapp.generated.resources.ic_back
import homemanagement.composeapp.generated.resources.sorry_try_again
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ErrorView(
    onGoBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.background)
            .padding(36.dp)
    ) {
        StatusBar()

        Spacer(
            modifier = Modifier.height(64.dp)
        )

        Text(
            text = stringResource(Res.string.error),
            style = AppTypography.h1Black,
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = stringResource(Res.string.sorry_try_again),
            style = AppTypography.bodyMediumRegular,
        )

        Spacer(
            modifier = Modifier.height(48.dp)
        )

        PrimaryButton(
            text = stringResource(Res.string.go_back),
            icon = painterResource(Res.drawable.ic_back),
            onClick = onGoBackClick,
            modifier = Modifier
                .fillMaxWidth()
            )

    }
}

@Preview
@Composable
fun ErrorViewPreview() = AppTheme {
    ErrorView(
        onGoBackClick = {},
    )
}