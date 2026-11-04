package com.martamazurkozlowska.homemanagement.ui.view.export

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
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
import homemanagement.composeapp.generated.resources.export_tasks
import homemanagement.composeapp.generated.resources.ic_export
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ExportView(
    json: String,
    onBackClick: () -> Unit,
    onExportClick: () -> Unit,
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
            title = stringResource(Res.string.export_tasks),
            icon = null,
            onBackClick = onBackClick,
            onIconClick = {},
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = json,
            style = AppTypography.bodySmallLight,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(color = AppColors.gray50, shape = AppShapes.exportTextField)
                .padding(16.dp)
                .verticalScroll(state = rememberScrollState())
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        PrimaryButton(
            text = stringResource(Res.string.export_tasks),
            icon = painterResource(Res.drawable.ic_export),
            onClick = onExportClick,
        )

        NavigationBar()
    }
}

@Preview
@Composable
fun ExportViewPreview() = AppTheme {
    ExportView(
        json = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
        onBackClick = {},
        onExportClick = {},
    )
}