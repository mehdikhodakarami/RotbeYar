package com.rotbeyar.app.presentation.common.model.student_dashboard.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color

data class ExamUi(
    val id : Long,
    @StringRes val title:Int,
    @DrawableRes val  icon:Int,
    val iconColor: Color,
    val iconContainerColor: Color,
    val formattedDate: String,
    val formattedHour: String,
    val daysLeft : Int,
    )