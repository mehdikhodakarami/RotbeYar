package com.rotbeyar.app.domain.model

import com.rotbeyar.app.presentation.common.model.Lesson

data class LessonResultExam(

    val lesson: Lesson = Lesson.BIOLOGY,
    val scorePercentage: Int = 90,
    val developPercentage: Int = 65,
    )
