package com.rotbeyar.app.domain.model

import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.Lesson

data class LessonDevelop(


    val lesson : Lesson=Lesson.BIOLOGY,

    val developStatus : EvaluationType = EvaluationType.NEEDS_IMPROVEMENT,

    val developPercentage: Int = 30

)



enum class EvaluationType(val stringRes: Int) {
    STRENGTH(R.string.strength),
    ACCEPTABLE(R.string.acceptable),
    NEEDS_IMPROVEMENT(R.string.needs_improvement),
    WEAKNESS(R.string.weakness),
}