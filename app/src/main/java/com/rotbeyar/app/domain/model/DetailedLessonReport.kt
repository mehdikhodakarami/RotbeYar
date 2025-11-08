package com.rotbeyar.app.domain.model

data class DetailedLessonReport(
    val lessonResultExam: LessonResultExam,
    val strengths: List<String> = emptyList(),
    val needToImprove: List<String> = emptyList(),
    val description: String = ""
)