package com.rotbeyar.app.presentation.student_dashboard.home.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.rotbeyar.app.R




sealed class StudentDashboardRoute(
    val route: String,
    @DrawableRes val icon: Int,
    @StringRes val title: Int
) {
    object Home : StudentDashboardRoute("home", R.drawable.home_icon, R.string.home)
    object Reports : StudentDashboardRoute("reports", R.drawable.report_icon, R.string.reports)
    object Plan : StudentDashboardRoute("plan", R.drawable.plan_icon, R.string.plan)
    object Counseling : StudentDashboardRoute("counseling", R.drawable.counslant_icon, R.string.counseling)
    object Profile : StudentDashboardRoute("profile", R.drawable.profile_icon, R.string.profile)


}