package com.martamazurkozlowska.homemanagement.ui.components.topappbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.homemanagement.ui.components.modifier.clickableWithRoundedEffect
import com.martamazurkozlowska.homemanagement.ui.theme.AppColors
import com.martamazurkozlowska.homemanagement.ui.theme.AppDimens
import com.martamazurkozlowska.homemanagement.ui.theme.AppTheme
import com.martamazurkozlowska.homemanagement.ui.theme.AppTypography
import homemanagement.composeapp.generated.resources.Res
import homemanagement.composeapp.generated.resources.back
import homemanagement.composeapp.generated.resources.ic_back
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SecondaryTopAppBarView(
    title: String,
    icon: Painter?,
    onBackClick: () -> Unit,
    onIconClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(AppColors.background)
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_back),
            contentDescription = stringResource(Res.string.back),
            tint = AppColors.icon,
            modifier = Modifier
                .size(AppDimens.iconSize)
                .clickableWithRoundedEffect(onClick = onBackClick)
        )

        Spacer(
            modifier = Modifier.width(20.dp)
        )

        Text(
            text = title,
            style = AppTypography.h2black,
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        if (icon != null) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = AppColors.green700,
                modifier = Modifier
                    .size(AppDimens.iconSize)
                    .clickableWithRoundedEffect(onClick = onIconClick)
            )
        }
    }
}

@Preview
@Composable
private fun SecondaryTopAppBarViewPreview() = AppTheme {
    SecondaryTopAppBarView(
        title = "New task",
        icon = null,
        onBackClick = {},
        onIconClick = {},
    )
}