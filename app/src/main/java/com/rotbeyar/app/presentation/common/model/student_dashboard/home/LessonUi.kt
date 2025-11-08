package com.rotbeyar.app.presentation.common.model.student_dashboard.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color

data class LessonUi(
    @StringRes val title: Int,
    @DrawableRes val  icon:Int,
    val iconColor: Color,
    val iconContainerColor: Color

)