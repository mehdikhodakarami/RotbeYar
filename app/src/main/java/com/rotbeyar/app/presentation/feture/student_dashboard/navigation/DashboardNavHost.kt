package com.rotbeyar.app.presentation.feture.student_dashboard.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rotbeyar.app.presentation.feture.student_dashboard.home.screens.HomeScreen
import com.rotbeyar.app.presentation.student_dashboard.navigation.StudentDashboardRoute


@Composable
fun DashboardNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = StudentDashboardRoute.Home,
        modifier = modifier
    ) {
        // Home Tab
        composable<StudentDashboardRoute.Home>(
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) }
        ) {
            HomeScreen()




        }

        // ReportsTab
        composable<StudentDashboardRoute.Reports>(
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) }
        )
        {

        }

        composable<StudentDashboardRoute.Plan>(
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) }
        ) {

        }

        composable<StudentDashboardRoute.Counseling>(
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) }
        ) {

        }

        composable<StudentDashboardRoute.Profile>(
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) }
        ) {

        }
    }
}