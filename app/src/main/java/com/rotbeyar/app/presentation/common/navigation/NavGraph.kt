package com.rotbeyar.app.presentation.common.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.rotbeyar.app.presentation.auth.navigation.authGraph
import com.rotbeyar.app.presentation.onboarding.onboardingGraph
import com.rotbeyar.app.presentation.student_dashboard.home.navigation.studentDashboardGraph


@Composable
fun NavApp(    navController: NavHostController,
){
    NavHost(navController = navController, startDestination = AppRoute.OnBoarding){
        onboardingGraph(navController,
            skipHandle = {
                navController.navigate(AppRoute.Auth){
                    popUpTo(AppRoute.OnBoarding){
                        inclusive = true
                    }
                }
            })
        authGraph(navController)
        studentDashboardGraph()

        }}




