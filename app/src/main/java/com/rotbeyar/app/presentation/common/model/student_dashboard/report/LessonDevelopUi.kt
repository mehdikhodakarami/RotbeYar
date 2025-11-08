package com.rotbeyar.app.presentation.common.model.student_dashboard.report

import androidx.compose.ui.graphics.Color
import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.Lesson
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.LessonUi
import com.rotbeyar.app.ui.theme.PrimaryBlue
import com.rotbeyar.app.ui.theme.PrimaryError
import com.rotbeyar.app.ui.theme.PrimaryGreen
import com.rotbeyar.app.ui.theme.PrimaryPurple

data class LessonDevelopUi (
    val lesson : LessonUi,
    val developStatus : EvaluationTypeUi = EvaluationTypeUi.STRENGTH,
    val developPercentage: Int = 30,



    )
enum class EvaluationTypeUi(val stringRes: Int, val color : Color) {
    STRENGTH(R.string.strength, PrimaryGreen),
    ACCEPTABLE(R.string.acceptable, PrimaryBlue),
    NEEDS_IMPROVEMENT(R.string.needs_improvement, PrimaryPurple),
    WEAKNESS(R.string.weakness, PrimaryError),
}