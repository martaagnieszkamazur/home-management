package com.martamazurkozlowska.homemanagement.ui.components.topappbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.homemanagement.ui.components.modifier.clickableWithRoundedEffect
import com.martamazurkozlowska.homemanagement.ui.theme.AppColors
import com.martamazurkozlowska.homemanagement.ui.theme.AppDimens
import com.martamazurkozlowska.homemanagement.ui.theme.AppTheme
import com.martamazurkozlowska.homemanagement.ui.theme.AppTypography
import homemanagement.composeapp.generated.resources.Res
import homemanagement.composeapp.generated.resources.ic_settings
import homemanagement.composeapp.generated.resources.settings
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TopAppBarView(
    text: String,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(AppColors.background)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = text,
                style = AppTypography.h1Black,
            )

            Icon(
                painter = painterResource(Res.drawable.ic_settings),
                contentDescription = stringResource(Res.string.settings),
                tint = AppColors.icon,
                modifier = Modifier
                    .size(AppDimens.iconSize)
                    .clickableWithRoundedEffect(onClick = onSettingsClick)
            )
        }

        HorizontalDivider()
    }

}

@Preview
@Composable
private fun TopAppBarViewPreview() = AppTheme {
    TopAppBarView(
        text = "HomeTaskido",
        onSettingsClick = {},
    )
}