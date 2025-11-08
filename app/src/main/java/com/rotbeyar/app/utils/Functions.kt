package com.rotbeyar.app.utils

import android.R.attr.category
import android.R.attr.description
import android.R.attr.name
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.domain.model.request.UpdateProfileRequest
import okhttp3.MultipartBody
import okhttp3.RequestBody

object AppRegex {
     val regex = "^[0-9]*$".toRegex()
     fun isEnglishNumber(text: String): Boolean {
         return text.matches(regex)
     }

 }

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



fun clockFromSec(seconds: Int =  3600,
): String {
    val _hours = seconds / 3600
    val hours = _hours.toString().padStart(2, '0')
    val _minutes =(seconds - _hours * 3600) / 60
    val minutes = _minutes.toString().padStart(2, '0')

    val remainingSeconds = (seconds - (_hours * 3600 + _minutes * 60)).toString().padStart(2, '0')
    return "$hours:$minutes:$remainingSeconds"

}




data class MultipartRequest(
    val textFields: Map<String, RequestBody>,
    val imagePart: MultipartBody.Part?
)


fun formatNumberWithCommas(number: Long): String {
    return "%,d".format(number)
}