package com.rotbeyar.app.presentation.feture.student_dashboard.home.states

import com.rotbeyar.app.domain.model.StudyPart
import com.rotbeyar.app.domain.model.Lesson


data class CurrentLessonState(
    val lesson: Lesson,
val studyPart: StudyPart,
val isLoading: Boolean = false,
    )
