package com.rotbeyar.app.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import kotlin.math.cos
import kotlin.math.sin

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)





val PrimaryBackgroundGradient = Brush.linearGradient(
    colors = listOf(
        Color(0x0D4F46E5), // 5% opacity: 0D = 13 in hex (~5%)
        Color(0x1A4F46E5)  // 10% opacity: 1A = 26 in hex (~10%)
    ),
    start = Offset.Zero,
    end = Offset.Infinite
)

val PinkGradientBrush = Brush.linearGradient(
    colors = listOf(
        Color(0xA855F7).copy(alpha = 0.1f),
        Color(0xEC4899).copy(alpha = 0.1f)
    ),
    start = Offset.Zero,
    end = Offset(
        x = cos(Math.toRadians(-65.0)).toFloat(),
        y = sin(Math.toRadians(-65.0)).toFloat()
    )
)

val GreenGradientBrush = Brush.linearGradient(
    colors = listOf(
        Color(0xFF4F46E5).copy(alpha = 0.1f), // شروع با 10% شفافیت
        Color(0xFF10B981).copy(alpha = 0.1f)  // پایان با 10% شفافیت
    ),
    start = Offset(0f, 0f),
    end = Offset(1000f, 0f) // افقی، می‌تونی زاویه‌اش رو تغییر بدی
)


val grayForTextLight = Color(0xFF6B7280)

val PrimaryPurple = Color(0xFF4F46E5)
val PrimaryPurpleContainer = Color(0xFF4F46E5)
val PrimaryGreen = Color(0xFF10B981)
val PrimaryGreenContainer = Color(0xFFDCFCE7)
val PrimaryWhite = Color(0xFFF9FAFB)
val PrimaryBlack = Color(0xFF1F2937)
val PrimaryGray = Color(0xFF9CA3AF)
val PrimaryGrayLight = Color(0xFFE5E7EB)

val PrimaryBlue=Color(0xFF2563EB)
val PrimaryBlueContainer = Color(0xFFDBEAFE)

val PrimaryError = Color(0xFFDC2626)
val PrimaryErrorContainer = Color(0xFFFEE2E2)

val GrayTextColor = Color(0xFF4B5563)


val Primary = Color(0xFF4F46E5)        // رنگ اصلی برند
val OnPrimary = Color(0xFFFFFFFF)      // نوشته روی primary
val Surface = Color.White              // رنگ کارت‌ها
val Outline = Color(0xFFC0CA33)        // رنگ placeholderها و border فیلدها

// گرادینت پس‌زمینه (در Theme نمیاد، فقط برای background custom استفاده می‌شه)
val BackgroundGradientStart = Color(0x0D4F46E5) // 5% opacity
val BackgroundGradientEnd = Color(0x1A4F46E5)   // 10% opacity

val Secondary = Color(0xFF6C63FF)
val OnSecondary = Color.White
val Background = Color.White
val OnBackground = Color(0xFF1F2937)
val OnSurface = Color(0xFF1F2937)
val Error = Color(0xFFB00020)
val OnError = Color.White

// val PrimaryContainer = ...
// val OnPrimaryContainer = ...
// val SecondaryContainer = ...
// val SurfaceVariant = ...
// val InverseOnSurface = ...
// ...

val AppColorScheme: ColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = OnPrimary,
    secondary = Secondary,
    onSecondary = OnSecondary,
    background = Background,
    onBackground = OnBackground,
    surface = Surface,
    onSurface = OnSurface,
    outline = Outline,
    error = Error,
    onError = OnError,
    // primaryContainer = ...,
    // onPrimaryContainer = ...,
    // secondaryContainer = ...,
    // surfaceVariant = ...,
)





val Purplegradient = Brush.linearGradient(
    colors = listOf(
        Color(0x1AA855F7),
        Color(0x1AEC4899)
    ),
    start = Offset.Zero,
    end = Offset.Infinite
)












val primaryLight = Color(0xFF4F46E5)
val onPrimaryLight = Color(0xFFFFFFFF)
val primaryContainerLight = Color(0x1A4F46E5)
val onPrimaryContainerLight = Color(0xFF4F46E5)
val secondaryLight = Color(0xFFF8F8F8)
val onSecondaryLight = Color(0xFF4B5563)
val secondaryContainerLight = Color(0xFFE5E7EB)
val onSecondaryContainerLight = Color(0xFF64676B)
val tertiaryLight = Color(0xFF685974)
val onTertiaryLight = Color(0xFFFFFFFF)
val tertiaryContainerLight = Color(0xFFF2DEFF)
val onTertiaryContainerLight = Color(0xFF6F607C)
val errorLight = Color(0xFFBA1A1A)
val onErrorLight = Color(0xFFFFFFFF)
val errorContainerLight = Color(0xFFFFDAD6)
val onErrorContainerLight = Color(0xFF93000A)
val backgroundLight = Color(0xFFFCF8FF)
val onBackgroundLight = Color(0xFF6B7280)
val surfaceLight = Color(0xFFFBF8FF)
val onSurfaceLight = Color(0xFF1B1B22)
val surfaceVariantLight = Color(0xFFE5E0F2)
val onSurfaceVariantLight = Color(0xFF9CA3AF)
val outlineLight = Color(0xFF787585)
val outlineVariantLight = Color(0xFFC8C4D6)
val scrimLight = Color(0xFF000000)
val inverseSurfaceLight = Color(0xFF303038)
val inverseOnSurfaceLight = Color(0xFFF2EFFA)
val inversePrimaryLight = Color(0xFFC3C0FF)
val surfaceDimLight = Color(0xFFDBD9E3)
val surfaceBrightLight = Color(0xFFFBF8FF)
val surfaceContainerLowestLight = Color(0xFFFFFFFF)
val surfaceContainerLowLight = Color(0xFFF5F2FD)
val surfaceContainerLight = Color(0xFFEFECF7)
val surfaceContainerHighLight = Color(0xFFE9E7F1)
val surfaceContainerHighestLight = Color(0xFFE3E1EC)

val primaryLightMediumContrast = Color(0xFF2100B6)
val onPrimaryLightMediumContrast = Color(0xFFFFFFFF)
val primaryContainerLightMediumContrast = Color(0xFF4F46E5)
val onPrimaryContainerLightMediumContrast = Color(0xFFFFFFFF)
val secondaryLightMediumContrast = Color(0xFF33363A)
val onSecondaryLightMediumContrast = Color(0xFFFFFFFF)
val secondaryContainerLightMediumContrast = Color(0xFF6A6D71)
val onSecondaryContainerLightMediumContrast = Color(0xFFFFFFFF)
val tertiaryLightMediumContrast = Color(0xFF3E314A)
val onTertiaryLightMediumContrast = Color(0xFFFFFFFF)
val tertiaryContainerLightMediumContrast = Color(0xFF776783)
val onTertiaryContainerLightMediumContrast = Color(0xFFFFFFFF)
val errorLightMediumContrast = Color(0xFF740006)
val onErrorLightMediumContrast = Color(0xFFFFFFFF)
val errorContainerLightMediumContrast = Color(0xFFCF2C27)
val onErrorContainerLightMediumContrast = Color(0xFFFFFFFF)
val backgroundLightMediumContrast = Color(0xFFFCF8FF)
val onBackgroundLightMediumContrast = Color(0xFF1B1B24)
val surfaceLightMediumContrast = Color(0xFFFBF8FF)
val onSurfaceLightMediumContrast = Color(0xFF101118)
val surfaceVariantLightMediumContrast = Color(0xFFE5E0F2)
val onSurfaceVariantLightMediumContrast = Color(0xFF363542)
val outlineLightMediumContrast = Color(0xFF53515F)
val outlineVariantLightMediumContrast = Color(0xFF6E6B7B)
val scrimLightMediumContrast = Color(0xFF000000)
val inverseSurfaceLightMediumContrast = Color(0xFF303038)
val inverseOnSurfaceLightMediumContrast = Color(0xFFF2EFFA)
val inversePrimaryLightMediumContrast = Color(0xFFC3C0FF)
val surfaceDimLightMediumContrast = Color(0xFFC7C5CF)
val surfaceBrightLightMediumContrast = Color(0xFFFBF8FF)
val surfaceContainerLowestLightMediumContrast = Color(0xFFFFFFFF)
val surfaceContainerLowLightMediumContrast = Color(0xFFF5F2FD)
val surfaceContainerLightMediumContrast = Color(0xFFE9E7F1)
val surfaceContainerHighLightMediumContrast = Color(0xFFDEDBE6)
val surfaceContainerHighestLightMediumContrast = Color(0xFFD2D0DB)

val primaryLightHighContrast = Color(0xFF1A0099)
val onPrimaryLightHighContrast = Color(0xFFFFFFFF)
val primaryContainerLightHighContrast = Color(0xFF3627CE)
val onPrimaryContainerLightHighContrast = Color(0xFFFFFFFF)
val secondaryLightHighContrast = Color(0xFF292C30)
val onSecondaryLightHighContrast = Color(0xFFFFFFFF)
val secondaryContainerLightHighContrast = Color(0xFF46494D)
val onSecondaryContainerLightHighContrast = Color(0xFFFFFFFF)
val tertiaryLightHighContrast = Color(0xFF34273F)
val onTertiaryLightHighContrast = Color(0xFFFFFFFF)
val tertiaryContainerLightHighContrast = Color(0xFF52445E)
val onTertiaryContainerLightHighContrast = Color(0xFFFFFFFF)
val errorLightHighContrast = Color(0xFF600004)
val onErrorLightHighContrast = Color(0xFFFFFFFF)
val errorContainerLightHighContrast = Color(0xFF98000A)
val onErrorContainerLightHighContrast = Color(0xFFFFFFFF)
val backgroundLightHighContrast = Color(0xFFFCF8FF)
val onBackgroundLightHighContrast = Color(0xFF1B1B24)
val surfaceLightHighContrast = Color(0xFFFBF8FF)
val onSurfaceLightHighContrast = Color(0xFF000000)
val surfaceVariantLightHighContrast = Color(0xFFE5E0F2)
val onSurfaceVariantLightHighContrast = Color(0xFF000000)
val outlineLightHighContrast = Color(0xFF2C2B38)
val outlineVariantLightHighContrast = Color(0xFF494756)
val scrimLightHighContrast = Color(0xFF000000)
val inverseSurfaceLightHighContrast = Color(0xFF303038)
val inverseOnSurfaceLightHighContrast = Color(0xFFFFFFFF)
val inversePrimaryLightHighContrast = Color(0xFFC3C0FF)
val surfaceDimLightHighContrast = Color(0xFFB9B7C2)
val surfaceBrightLightHighContrast = Color(0xFFFBF8FF)
val surfaceContainerLowestLightHighContrast = Color(0xFFFFFFFF)
val surfaceContainerLowLightHighContrast = Color(0xFFF2EFFA)
val surfaceContainerLightHighContrast = Color(0xFFE3E1EC)
val surfaceContainerHighLightHighContrast = Color(0xFFD5D3DD)
val surfaceContainerHighestLightHighContrast = Color(0xFFC7C5CF)

val primaryDark = Color(0xFFC3C0FF)
val onPrimaryDark = Color(0xFF1D00A5)
val primaryContainerDark = Color(0xFF4F46E5)
val onPrimaryContainerDark = Color(0xFFDAD7FF)
val secondaryDark = Color(0xFFFFFFFF)
val onSecondaryDark = Color(0xFF2D3134)
val secondaryContainerDark = Color(0xFFE0E2E6)
val onSecondaryContainerDark = Color(0xFF626568)
val tertiaryDark = Color(0xFFFFFFFF)
val onTertiaryDark = Color(0xFF382B44)
val tertiaryContainerDark = Color(0xFFEFDBFC)
val onTertiaryContainerDark = Color(0xFF6E5E7A)
val errorDark = Color(0xFFFFB4AB)
val onErrorDark = Color(0xFF690005)
val errorContainerDark = Color(0xFF93000A)
val onErrorContainerDark = Color(0xFFFFDAD6)
val backgroundDark = Color(0xFF13121B)
val onBackgroundDark = Color(0xFFE4E1EE)
val surfaceDark = Color(0xFF12131A)
val onSurfaceDark = Color(0xFFE3E1EC)
val surfaceVariantDark = Color(0xFF474553)
val onSurfaceVariantDark = Color(0xFFC8C4D6)
val outlineDark = Color(0xFF928F9F)
val outlineVariantDark = Color(0xFF474553)
val scrimDark = Color(0xFF000000)
val inverseSurfaceDark = Color(0xFFE3E1EC)
val inverseOnSurfaceDark = Color(0xFF303038)
val inversePrimaryDark = Color(0xFF4D44E3)
val surfaceDimDark = Color(0xFF12131A)
val surfaceBrightDark = Color(0xFF383841)
val surfaceContainerLowestDark = Color(0xFF0D0E15)
val surfaceContainerLowDark = Color(0xFF1B1B22)
val surfaceContainerDark = Color(0xFF1F1F26)
val surfaceContainerHighDark = Color(0xFF292931)
val surfaceContainerHighestDark = Color(0xFF34343C)

val primaryDarkMediumContrast = Color(0xFFDBD8FF)
val onPrimaryDarkMediumContrast = Color(0xFF160086)
val primaryContainerDarkMediumContrast = Color(0xFF8582FF)
val onPrimaryContainerDarkMediumContrast = Color(0xFF000000)
val secondaryDarkMediumContrast = Color(0xFFFFFFFF)
val onSecondaryDarkMediumContrast = Color(0xFF2D3134)
val secondaryContainerDarkMediumContrast = Color(0xFFE0E2E6)
val onSecondaryContainerDarkMediumContrast = Color(0xFF45484C)
val tertiaryDarkMediumContrast = Color(0xFFFFFFFF)
val onTertiaryDarkMediumContrast = Color(0xFF382B44)
val tertiaryContainerDarkMediumContrast = Color(0xFFEFDBFC)
val onTertiaryContainerDarkMediumContrast = Color(0xFF50425D)
val errorDarkMediumContrast = Color(0xFFFFD2CC)
val onErrorDarkMediumContrast = Color(0xFF540003)
val errorContainerDarkMediumContrast = Color(0xFFFF5449)
val onErrorContainerDarkMediumContrast = Color(0xFF000000)
val backgroundDarkMediumContrast = Color(0xFF13121B)
val onBackgroundDarkMediumContrast = Color(0xFFE4E1EE)
val surfaceDarkMediumContrast = Color(0xFF12131A)
val onSurfaceDarkMediumContrast = Color(0xFFFFFFFF)
val surfaceVariantDarkMediumContrast = Color(0xFF474553)
val onSurfaceVariantDarkMediumContrast = Color(0xFFDEDAEC)
val outlineDarkMediumContrast = Color(0xFFB3B0C1)
val outlineVariantDarkMediumContrast = Color(0xFF918E9F)
val scrimDarkMediumContrast = Color(0xFF000000)
val inverseSurfaceDarkMediumContrast = Color(0xFFE3E1EC)
val inverseOnSurfaceDarkMediumContrast = Color(0xFF292931)
val inversePrimaryDarkMediumContrast = Color(0xFF3525CD)
val surfaceDimDarkMediumContrast = Color(0xFF12131A)
val surfaceBrightDarkMediumContrast = Color(0xFF44444C)
val surfaceContainerLowestDarkMediumContrast = Color(0xFF07070D)
val surfaceContainerLowDarkMediumContrast = Color(0xFF1D1D24)
val surfaceContainerDarkMediumContrast = Color(0xFF27272F)
val surfaceContainerHighDarkMediumContrast = Color(0xFF32323A)
val surfaceContainerHighestDarkMediumContrast = Color(0xFF3D3D45)

val primaryDarkHighContrast = Color(0xFFF1EEFF)
val onPrimaryDarkHighContrast = Color(0xFF000000)
val primaryContainerDarkHighContrast = Color(0xFFBEBCFF)
val onPrimaryContainerDarkHighContrast = Color(0xFF05003A)
val secondaryDarkHighContrast = Color(0xFFFFFFFF)
val onSecondaryDarkHighContrast = Color(0xFF000000)
val secondaryContainerDarkHighContrast = Color(0xFFE0E2E6)
val onSecondaryContainerDarkHighContrast = Color(0xFF272A2D)
val tertiaryDarkHighContrast = Color(0xFFFFFFFF)
val onTertiaryDarkHighContrast = Color(0xFF000000)
val tertiaryContainerDarkHighContrast = Color(0xFFEFDBFC)
val onTertiaryContainerDarkHighContrast = Color(0xFF31253D)
val errorDarkHighContrast = Color(0xFFFFECE9)
val onErrorDarkHighContrast = Color(0xFF000000)
val errorContainerDarkHighContrast = Color(0xFFFFAEA4)
val onErrorContainerDarkHighContrast = Color(0xFF220001)
val backgroundDarkHighContrast = Color(0xFF13121B)
val onBackgroundDarkHighContrast = Color(0xFFE4E1EE)
val surfaceDarkHighContrast = Color(0xFF12131A)
val onSurfaceDarkHighContrast = Color(0xFFFFFFFF)
val surfaceVariantDarkHighContrast = Color(0xFF474553)
val onSurfaceVariantDarkHighContrast = Color(0xFFFFFFFF)
val outlineDarkHighContrast = Color(0xFFF2EDFF)
val outlineVariantDarkHighContrast = Color(0xFFC4C0D2)
val scrimDarkHighContrast = Color(0xFF000000)
val inverseSurfaceDarkHighContrast = Color(0xFFE3E1EC)
val inverseOnSurfaceDarkHighContrast = Color(0xFF000000)
val inversePrimaryDarkHighContrast = Color(0xFF3525CD)
val surfaceDimDarkHighContrast = Color(0xFF12131A)
val surfaceBrightDarkHighContrast = Color(0xFF504F58)
val surfaceContainerLowestDarkHighContrast = Color(0xFF000000)
val surfaceContainerLowDarkHighContrast = Color(0xFF1F1F26)
val surfaceContainerDarkHighContrast = Color(0xFF303038)
val surfaceContainerHighDarkHighContrast = Color(0xFF3B3B43)
val surfaceContainerHighestDarkHighContrast = Color(0xFF46464E)

val onSecondoryLight = Color(0xFF343E4B)
val onOnSecondoryLight = Color(0xFFFFFFFF)
val onSecondoryContainerLight = Color(0xFF4B5563)
val onOnSecondoryContainerLight = Color(0xFFBFCADA)

val onSecondoryLightMediumContrast = Color(0xFF2D3744)
val onOnSecondoryLightMediumContrast = Color(0xFFFFFFFF)
val onSecondoryContainerLightMediumContrast = Color(0xFF4B5563)
val onOnSecondoryContainerLightMediumContrast = Color(0xFFF5F7FF)

val onSecondoryLightHighContrast = Color(0xFF232D3A)
val onOnSecondoryLightHighContrast = Color(0xFFFFFFFF)
val onSecondoryContainerLightHighContrast = Color(0xFF404A58)
val onOnSecondoryContainerLightHighContrast = Color(0xFFFFFFFF)

val onSecondoryDark = Color(0xFFBDC7D8)
val onOnSecondoryDark = Color(0xFF27313E)
val onSecondoryContainerDark = Color(0xFF4B5563)
val onOnSecondoryContainerDark = Color(0xFFBFCADA)

val onSecondoryDarkMediumContrast = Color(0xFFD3DDEE)
val onOnSecondoryDarkMediumContrast = Color(0xFF1C2633)
val onSecondoryContainerDarkMediumContrast = Color(0xFF8791A1)
val onOnSecondoryContainerDarkMediumContrast = Color(0xFF000000)

val onSecondoryDarkHighContrast = Color(0xFFE8F0FF)
val onOnSecondoryDarkHighContrast = Color(0xFF000000)
val onSecondoryContainerDarkHighContrast = Color(0xFFB9C3D4)
val onOnSecondoryContainerDarkHighContrast = Color(0xFF030C17)


