package com.rotbeyar.app.presentation.feture.student_dashboard.home.states

import com.rotbeyar.app.domain.model.Exam

data class NextExamState(
    val exam: Exam ,
    val daysLeft: Int = 10
    )
