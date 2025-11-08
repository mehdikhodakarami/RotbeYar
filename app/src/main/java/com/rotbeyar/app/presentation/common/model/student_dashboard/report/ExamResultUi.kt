package com.rotbeyar.app.presentation.common.model.student_dashboard.report

import com.rotbeyar.app.domain.model.AppGrgDateTime
import com.rotbeyar.app.domain.model.Exam
import com.rotbeyar.app.domain.model.LessonResultExam
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ExamUi

data class ExamResultUi(

    val exam: ExamUi,
    val date: AppGrgDateTime = AppGrgDateTime(1,2,3),
    val totalScore  :Int = 7000,
    val lessonResultExams : List<LessonResultExamUi> = emptyList()

)
