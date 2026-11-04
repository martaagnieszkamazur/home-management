package com.martamazurkozlowska.homemanagement.ui.view.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.martamazurkozlowska.homemanagement.ui.theme.AppTheme
import homemanagement.composeapp.generated.resources.Res
import homemanagement.composeapp.generated.resources.export_tasks
import homemanagement.composeapp.generated.resources.ic_export
import homemanagement.composeapp.generated.resources.ic_import
import homemanagement.composeapp.generated.resources.import_tasks
import homemanagement.composeapp.generated.resources.settings
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SettingsView(
    onBackClick: () -> Unit,
    onImportTasksClick: () -> Unit,
    onExportTasksClick: () -> Unit,
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
            title = stringResource(Res.string.settings),
            icon = null,
            onBackClick = onBackClick,
            onIconClick = {},
        )

        Spacer(
            modifier = Modifier.height(64.dp)
        )

        PrimaryButton(
            text = stringResource(Res.string.import_tasks),
            icon = painterResource(Res.drawable.ic_import),
            onClick = onImportTasksClick,
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        PrimaryButton(
            text = stringResource(Res.string.export_tasks),
            icon = painterResource(Res.drawable.ic_export),
            onClick = onExportTasksClick,
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        NavigationBar()
    }
}

@Preview
@Composable
private fun SettingsViewPreview() = AppTheme {
    SettingsView(
        onBackClick = {},
        onImportTasksClick = {},
        onExportTasksClick = {},
    )
}