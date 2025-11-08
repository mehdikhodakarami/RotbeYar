package com.rotbeyar.app.presentation.common.model.student_dashboard.report


data class DetailedLessonReportUi(

    val lessonResultExam: LessonResultExamUi,
    val strengths: List<String> = emptyList(),
    val needToImprove: List<String> = emptyList(),
    val description: String = ""
)
