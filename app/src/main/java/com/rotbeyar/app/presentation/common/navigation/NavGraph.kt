package com.rotbeyar.app.presentation.common.navigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.rotbeyar.app.presentation.MainViewModel
import com.rotbeyar.app.presentation.feture.auth.AuthStatus
import com.rotbeyar.app.presentation.feture.auth.navigation.authGraph
import com.rotbeyar.app.presentation.feture.onboarding.onboardingGraph
import com.rotbeyar.app.presentation.feture.splash.navigation.splashGraph
import com.rotbeyar.app.presentation.feture.student_dashboard.home.navigation.studentDashboardGraph


@Composable
fun NavApp(
    mainViewModel: MainViewModel = hiltViewModel(),
    navController: NavHostController,
){

    val authState by mainViewModel.authState.collectAsState()
    var shouldCompleteProfile by remember {mutableStateOf(false)}
    val startDestination = remember(authState) {
        when (val state = authState) {
            is AuthStatus.Loading -> {
                AppRoute.Splash
            }
            is AuthStatus.Authenticated -> {
                if (state.firstName.isNullOrEmpty()) {
                    shouldCompleteProfile = true
                    AppRoute.Auth

                } else {
                    shouldCompleteProfile  = false
                    AppRoute.StudentDashboard
                }
            }
            is AuthStatus.NotAuthenticated -> {
                shouldCompleteProfile = false
                AppRoute.OnBoarding
            }
            is AuthStatus.TokenExpired -> {
                AppRoute.OnBoarding
            }
        }}
    NavHost(navController = navController,
        startDestination = startDestination){
        onboardingGraph(navController,
            skipHandle = {
                navController.navigate(AppRoute.Auth){
                    popUpTo(AppRoute.OnBoarding){
                        inclusive = true
                    }
                }
            })




        authGraph( shouldCompleteProfile = shouldCompleteProfile,
            navController =navController,
            onFinished ={navController.navigate(AppRoute.StudentDashboard){

            popUpTo(AppRoute.OnBoarding){
                inclusive = true
            }
        } })




        studentDashboardGraph()


        splashGraph()




        }


}

