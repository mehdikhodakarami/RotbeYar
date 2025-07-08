package com.rotbeyar.app.presentation.student_dashboard.home.model

sealed class HomeCardModel {
    data class  CurrentLessonPlan(
        val studyTime : String,
        val lessonTitle:String,
        val lessonPartDetail: String,
        val testCount : Int,
        val pageCount : Int,
        val studyDuration: Int,
        val startStudyClick:()->Unit):HomeCardModel()




}