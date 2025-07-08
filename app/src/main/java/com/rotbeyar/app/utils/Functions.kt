package com.rotbeyar.app.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

fun String.toEnglishDigits(): String {
    return this
        .replace('۰', '0')
        .replace('۱', '1')
        .replace('۲', '2')
        .replace('۳', '3')
        .replace('۴', '4')
        .replace('۵', '5')
        .replace('۶', '6')
        .replace('۷', '7')
        .replace('۸', '8')
        .replace('۹', '9')
}


fun formatSecondsToTime(seconds: Int): String {
    val hours = seconds / 3600
    val minutes = (seconds % 3600) / 60
    val secs = seconds % 60
    return String.format("%02d:%02d:%02d", hours, minutes, secs)
}

operator fun PaddingValues.plus(other: PaddingValues): PaddingValues {
    return PaddingValues(
        start = this.calculateStartPadding(LayoutDirection.Rtl) + 16.dp,
        top = this.calculateTopPadding() + 16.dp,
        end = this.calculateEndPadding(LayoutDirection.Rtl) + other.calculateBottomPadding(),
        bottom = this.calculateBottomPadding() + other.calculateBottomPadding()
    )



}

