package com.rotbeyar.app.presentation.common.model.student_dashboard.plan

import com.rotbeyar.app.presentation.common.model.student_dashboard.home.LessonUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyLessonUi

data class LessonDevelopmentInWeekUi(
   val lesson : LessonUi ,
    val countTestInWeek : Int,
   val countStudyHourInWeek : Int,
   )
