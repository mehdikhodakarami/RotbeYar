package com.rotbeyar.app.domain.model

import com.rotbeyar.app.presentation.common.model.Lesson

data class StudyLesson(
    val lesson: Lesson,
    val part: StudyPart,
    val durationMinutes: Int,
    val solvedTests: Int = 0,
    val notes: String? = null
)