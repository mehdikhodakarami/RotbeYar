package com.rotbeyar.app.presentation.feture.splash.navigation

import kotlinx.serialization.Serializable
@Serializable
sealed class SplashRoute {
    @Serializable
    object MainSplashScreen : SplashRoute()
}