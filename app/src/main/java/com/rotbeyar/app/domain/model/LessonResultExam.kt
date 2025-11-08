package com.rotbeyar.app.domain.model

import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.Lesson

data class LessonResultExam(
val lessonDevelop: LessonDevelop,
    val scorePercentage: Int = 90,
    )
