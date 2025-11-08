package com.rotbeyar.app.presentation.feture.onboarding

import kotlinx.serialization.Serializable


@Serializable
sealed class OnBoardingRoute() {
    @Serializable
object IntroPager : OnBoardingRoute()

}
