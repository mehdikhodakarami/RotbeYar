package com.rotbeyar.app.presentation.common.model

import androidx.compose.runtime.Composable
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.LessonUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.SampleStudentDashboardData

data class SuggestedReferenceUi(
    val lessonUi: LessonUi,
    val textBookTitle : String,
    val textBookFeature: String,
    val testBookTitle : String,
    val testBookFeature: String

)
