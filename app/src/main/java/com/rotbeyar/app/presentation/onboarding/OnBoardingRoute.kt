package com.rotbeyar.app.presentation.onboarding

import kotlinx.serialization.Serializable


@Serializable
sealed class OnBoardingRoute() {
    @Serializable
object IntroPager : OnBoardingRoute()

}
