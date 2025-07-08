package com.rotbeyar.app.presentation.common.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.rotbeyar.app.R
import com.rotbeyar.app.ui.theme.PrimaryBlue
import com.rotbeyar.app.ui.theme.PrimaryBlueContainer
import com.rotbeyar.app.ui.theme.PrimaryError
import com.rotbeyar.app.ui.theme.PrimaryErrorContainer
import com.rotbeyar.app.ui.theme.PrimaryGreen
import com.rotbeyar.app.ui.theme.PrimaryGreenContainer
import com.rotbeyar.app.ui.theme.PrimaryPurple
import com.rotbeyar.app.ui.theme.PrimaryPurpleContainer

enum class Lesson(val displayName: Int, @DrawableRes val  icon:Int, val iconColor:Color, val iconContainerColor: Color) {
    BIOLOGY(
        R.string.lesson_biology,
        R.drawable.biology_icon,
        PrimaryPurple,
        PrimaryPurpleContainer
        ),

    CHEMISTRY(R.string.lesson_chemistry,
        R.drawable.chemistry_icon,
        PrimaryGreen,
        PrimaryGreenContainer
    ),

    PHYSICS(R.string.lesson_physics,
        R.drawable.physics_icon
        , PrimaryBlue,
        PrimaryBlueContainer
    ),
    MATH(R.string.lesson_math,
        R.drawable.math_icon,
        PrimaryError,
        PrimaryErrorContainer
    ),
}