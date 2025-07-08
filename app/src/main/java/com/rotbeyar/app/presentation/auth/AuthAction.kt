package com.rotbeyar.app.presentation.auth

import com.rotbeyar.app.domain.model.UserRole

sealed class AuthAction {


    data class EmailInputChanged(val email: String) : AuthAction()
    data class PasswordInputChanged(val password: String) : AuthAction()
    data class FullNameInputChanged(val fullName: String) : AuthAction()
    data class SelectRole(val role: UserRole) : AuthAction()

    object SubmitLogin : AuthAction()
    data class SubmitRegister(val role: UserRole) : AuthAction()

    object ForgotPasswordClick : AuthAction()
    data class PasswordResetRequest(val email: String) : AuthAction()
    data class ShowPasswordResetDialog(val show: Boolean) : AuthAction()

    object SubmitLogout : AuthAction()

}
