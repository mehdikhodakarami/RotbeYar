package com.rotbeyar.app.presentation.common.model.student_dashboard.home

data class StudyLessonUi(
    val lesson: LessonUi,
    val subject: String,
    val durationMinutes: Int,
    val testsCount: Int,
    val pageCount : Int = 0,
    val startTime :String,
    val endtime : String,
    val status: StudyPartStatusUi = StudyPartStatusUi.IN_PROGRESS,
    val notes: String? = null

)
