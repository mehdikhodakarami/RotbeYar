package com.rotbeyar.app.presentation.feture.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rotbeyar.app.presentation.common.navigation.AppRoute
import com.rotbeyar.app.presentation.feture.splash.screens.SplashScreen

fun NavGraphBuilder.splashGraph(

    ){

    navigation<AppRoute.Splash>(
        startDestination = SplashRoute.MainSplashScreen
    )


    {
        composable<SplashRoute.MainSplashScreen> {
            SplashScreen()

        }



    }










}