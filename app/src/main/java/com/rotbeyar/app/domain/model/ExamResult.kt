package com.rotbeyar.app.domain.model

data class ExamResult(
    val exam: Exam = Exam(),
    val date: AppGrgDateTime = AppGrgDateTime(1,2,3),
    val totalScore  :Int = 7000,
   val lessonResultExams : List<LessonResultExam> = emptyList()

)
