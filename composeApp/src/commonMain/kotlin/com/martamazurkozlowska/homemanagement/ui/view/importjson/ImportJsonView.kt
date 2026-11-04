package com.martamazurkozlowska.homemanagement.ui.view.importjson

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.homemanagement.ui.components.button.PrimaryButton
import com.martamazurkozlowska.homemanagement.ui.components.navigationbar.NavigationBar
import com.martamazurkozlowska.homemanagement.ui.components.statusbar.StatusBar
import com.martamazurkozlowska.homemanagement.ui.components.topappbar.SecondaryTopAppBarView
import com.martamazurkozlowska.homemanagement.ui.theme.AppColors
import com.martamazurkozlowska.homemanagement.ui.theme.AppShapes
import com.martamazurkozlowska.homemanagement.ui.theme.AppTheme
import com.martamazurkozlowska.homemanagement.ui.theme.AppTypography
import homemanagement.composeapp.generated.resources.Res
import homemanagement.composeapp.generated.resources.ic_import
import homemanagement.composeapp.generated.resources.import_tasks
import homemanagement.composeapp.generated.resources.paste_tasks
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ImportJsonView(
    jsonTextFieldState: TextFieldState,
    onBackClick: () -> Unit,
    onImportClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.background)
            .padding(16.dp)
    ) {
        StatusBar()

        SecondaryTopAppBarView(
            title = stringResource(Res.string.import_tasks),
            icon = null,
            onBackClick = onBackClick,
            onIconClick = {},
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        TextField(
            state = jsonTextFieldState,
            shape = AppShapes.exportTextField,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = AppColors.gray50,
                focusedIndicatorColor = AppColors.gray50,
                unfocusedContainerColor = AppColors.gray100,
                unfocusedIndicatorColor = AppColors.gray100
            ),
            textStyle = AppTypography.bodySmallLight,
            placeholder = {
                Text(
                    text = stringResource(Res.string.paste_tasks),
                    style = AppTypography.bodySmallLight,
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        PrimaryButton(
            text = stringResource(Res.string.import_tasks),
            icon = painterResource(Res.drawable.ic_import),
            onClick = onImportClick,
        )

        NavigationBar()
    }
}

@Preview
@Composable
fun ImportJsonViewPreview() = AppTheme {
    ImportJsonView(
        jsonTextFieldState = TextFieldState(
            initialText = "json"
        ),
        onBackClick = {},
        onImportClick = {},
    )
}
