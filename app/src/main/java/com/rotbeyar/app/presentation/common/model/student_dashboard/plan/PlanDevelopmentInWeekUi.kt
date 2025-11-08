package com.rotbeyar.app.presentation.common.model.student_dashboard.plan

data class PlanDevelopmentInWeekUi(
    val listOfStudy : List<LessonDevelopmentInWeekUi> ,
    val overallCountTest : Int ,
    val overallCountStudyHour : Int
)
