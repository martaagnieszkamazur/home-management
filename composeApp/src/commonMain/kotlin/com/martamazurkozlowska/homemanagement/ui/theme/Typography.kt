package com.martamazurkozlowska.homemanagement.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import homemanagement.composeapp.generated.resources.Res
import homemanagement.composeapp.generated.resources.jakarta_bold
import homemanagement.composeapp.generated.resources.jakarta_extra_bold
import homemanagement.composeapp.generated.resources.jakarta_light
import homemanagement.composeapp.generated.resources.jakarta_regular
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

data class Typography(
    val h1Bold: TextStyle = TextStyle(),
    val h1Black: TextStyle = TextStyle(),
    val h2Bold: TextStyle = TextStyle(),
    val h2black: TextStyle = TextStyle(),
    val h3Regular: TextStyle = TextStyle(),
    val h3Bold: TextStyle = TextStyle(),
    val bodyMediumBlack: TextStyle = TextStyle(),
    val bodyMediumRegular: TextStyle = TextStyle(),
    val bodySmallBlack: TextStyle = TextStyle(),
    val bodySmallLight: TextStyle = TextStyle(),
    val label: TextStyle = TextStyle(),
)

@Composable
fun createTypography(): Typography {
    val fontFamily = getAppFontFamily()
    return Typography(
        h1Bold = TextStyle(
            color = AppColors.text,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            lineHeight = 40.sp,
            letterSpacing = 0.sp,
        ),
        h1Black = TextStyle(
            brush = Brush.linearGradient(
                0.0f to AppColors.green700,
                0.9f to AppColors.green400
            ),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 32.sp,
            lineHeight = 48.sp,
            letterSpacing = 0.sp,
        ),
        h2Bold = TextStyle(
            color = AppColors.text,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.sp,
        ),
        h2black = TextStyle(
            brush = Brush.linearGradient(
                0.0f to AppColors.green700,
                0.9f to AppColors.green400
            ),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 24.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.sp,
        ),
        h3Regular = TextStyle(
            color = AppColors.text,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            lineHeight = 30.sp,
            letterSpacing = 0.sp,
        ),
        h3Bold = TextStyle(
            color = AppColors.text,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            lineHeight = 30.sp,
            letterSpacing = 0.sp,
        ),
        bodyMediumBlack = TextStyle(
            color = AppColors.text,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 18.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp,
        ),
        bodyMediumRegular = TextStyle(
            color = AppColors.text,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp,
        ),
        bodySmallBlack = TextStyle(
            color = AppColors.gray500,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.sp,
        ),
        bodySmallLight = TextStyle(
            color = AppColors.text,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.sp,
        ),
        label = TextStyle(
            color = AppColors.gray50,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            lineHeight = 14.sp,
            letterSpacing = 0.sp,
        ),
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun getAppFontFamily() = FontFamily(
    Font(
        resource = Res.font.jakarta_extra_bold,
        weight = FontWeight.Black,
    ),
    Font(
        resource = Res.font.jakarta_bold,
        weight = FontWeight.Bold,
    ),
    Font(
        resource = Res.font.jakarta_regular,
        weight = FontWeight.Normal,
    ),
    Font(
        resource = Res.font.jakarta_light,
        weight = FontWeight.Light,
    )
)
