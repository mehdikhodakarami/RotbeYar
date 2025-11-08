package com.rotbeyar.app.presentation.student_dashboard.navigation

import kotlinx.serialization.Serializable

sealed class StudentDashboardRoute {

    @Serializable
    data object Home : StudentDashboardRoute()

    @Serializable
    data object Reports : StudentDashboardRoute()

    @Serializable
    data object Plan : StudentDashboardRoute()

    @Serializable
    data object Counseling : StudentDashboardRoute()

    @Serializable
    data object Profile : StudentDashboardRoute()

    companion object {
        val items = listOf(Home, Reports, Plan, Counseling, Profile)


    }
}