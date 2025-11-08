package com.rotbeyar.app.presentation.feture.student_dashboard.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rotbeyar.app.presentation.common.navigation.AppRoute
import com.rotbeyar.app.presentation.feture.student_dashboard.home.screens.HomeScreen
import com.rotbeyar.app.presentation.student_dashboard.navigation.StudentDashboardRoute

fun NavGraphBuilder.studentDashboardGraph(){
    navigation<AppRoute.StudentDashboard>(
        startDestination = StudentDashboardRoute.Home
    ){
        composable<StudentDashboardRoute.Home> {
            HomeScreen()
        }
        composable < StudentDashboardRoute.Reports>{

        }
        composable < StudentDashboardRoute.Plan>{

        }
        composable < StudentDashboardRoute.Counseling>{

        }
        composable < StudentDashboardRoute.Profile>{

        }

        }




}