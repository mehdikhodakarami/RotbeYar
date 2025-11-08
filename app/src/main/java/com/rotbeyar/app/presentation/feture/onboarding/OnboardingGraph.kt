package com.rotbeyar.app.presentation.feture.onboarding
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

import com.rotbeyar.app.presentation.common.navigation.AppRoute
import com.rotbeyar.app.presentation.feture.onboarding.screens.IntroPage

fun NavGraphBuilder.onboardingGraph(navController: NavController,skipHandle : ()->Unit) {
    navigation<AppRoute.OnBoarding>(
        startDestination = OnBoardingRoute.IntroPager,
    ) {
composable<OnBoardingRoute.IntroPager>{
    IntroPage(onSkip = skipHandle)

}



    }
}