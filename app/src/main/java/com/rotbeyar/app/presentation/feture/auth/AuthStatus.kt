package com.rotbeyar.app.presentation.feture.auth

sealed class AuthStatus {
    object NotAuthenticated : AuthStatus()
    object Loading : AuthStatus()


    data class Authenticated(
        val userId: Long? = null,
        val firstName: String? = null,
        val lastName: String? = null,
        val email: String? = null,
        val phone: String? = null
    ) : AuthStatus()


    data class TokenExpired(
        val canRefresh: Boolean
    ) : AuthStatus()
}