package com.rotbeyar.app.presentation.common.model.student_dashboard.report

import com.rotbeyar.app.presentation.common.model.student_dashboard.home.LessonUi

data class StudyInDayUi(
    // Lesson to studyHoursTime
    val lessonsProgress: Map<LessonUi, Int>
)



