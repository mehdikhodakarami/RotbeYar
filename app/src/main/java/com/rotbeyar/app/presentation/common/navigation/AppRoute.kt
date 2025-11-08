package com.rotbeyar.app.presentation.common.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AppRoute () {
        @Serializable

         object  Splash : AppRoute()
        @Serializable
        object OnBoarding : AppRoute()

      @Serializable
      object Auth : AppRoute()

    @Serializable
    object  StudentDashboard : AppRoute()


}