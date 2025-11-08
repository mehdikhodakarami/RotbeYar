package com.rotbeyar.app.presentation.feture.auth.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AuthRoute() {
    @Serializable
    object InsertPhoneNumber : AuthRoute()
    @Serializable
    object VerifyPhoneNumber : AuthRoute()
    @Serializable
    object InsertNameLastName : AuthRoute()

}
