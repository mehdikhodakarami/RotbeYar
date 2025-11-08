package com.rotbeyar.app.presentation.feture.student_dashboard.home.action

sealed class HomeStudentAction {
    object RefreshData : HomeStudentAction()
    object StartStudyCurrentLesson : HomeStudentAction()
    object ViewTodayDevelopmentDetails : HomeStudentAction()
    object ViewAllNextExams : HomeStudentAction()
    data class RecordExamResult(val examId: String) : HomeStudentAction()
    data class ViewExamTopics(val examId: String) : HomeStudentAction()
    data class IncreaseTestLessonStudy(val lessonId: String) : HomeStudentAction()
    data class DecreaseTestLessonStudy(val lessonId: String) : HomeStudentAction()
    data class CheckLessonStudy(val lessonId: String) : HomeStudentAction()
}