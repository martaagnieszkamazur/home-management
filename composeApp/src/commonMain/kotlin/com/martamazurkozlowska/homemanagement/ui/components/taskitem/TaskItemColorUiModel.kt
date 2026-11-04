package com.martamazurkozlowska.homemanagement.ui.components.taskitem

import androidx.compose.ui.graphics.Color
import com.martamazurkozlowska.homemanagement.ui.theme.AppColors

enum class TaskItemColorUiModel(
    val primaryColor: Color,
    val secondaryColor: Color,
    val tertiaryColor: Color,
) {
    Green(
        primaryColor = AppColors.greenPrimary,
        secondaryColor = AppColors.green700,
        tertiaryColor = AppColors.gray50,
    ),


    Blue(
        primaryColor = AppColors.bluePrimary,
        secondaryColor = AppColors.blue700,
        tertiaryColor = AppColors.purple50,
    ),

    Purple(
        primaryColor = AppColors.purplePrimary,
        secondaryColor = AppColors.purple700,
        tertiaryColor = AppColors.purple50,
    ),

    Orange(
        primaryColor = AppColors.orangePrimary,
        secondaryColor = AppColors.orange700,
        tertiaryColor = AppColors.yellow50,
    ),

    Yellow(
        primaryColor = AppColors.yellowPrimary,
        secondaryColor = AppColors.yellow700,
        tertiaryColor = AppColors.gray50,
    ),
}