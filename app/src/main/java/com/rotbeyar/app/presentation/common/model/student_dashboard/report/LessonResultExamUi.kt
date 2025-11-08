package com.rotbeyar.app.presentation.common.model.student_dashboard.report

import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.Lesson
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.LessonUi

data class LessonResultExamUi(
    val lessonDevelopUi: LessonDevelopUi,
    val scorePercentage: Int = 90,

)
