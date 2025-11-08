package com.rotbeyar.app.domain.model


data class StudyLesson(
    val lesson: Lesson,
    val subject: String,
    val durationSeconds: Int,
    val tests: Int,
    val pageCount : Int = 0,
    val studyPart: StudyPart,
    val status: StudyPartStatus = StudyPartStatus.IN_PROGRESS,
    val notes: String? = null
)