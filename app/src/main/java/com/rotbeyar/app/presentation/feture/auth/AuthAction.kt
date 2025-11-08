package com.rotbeyar.app.presentation.feture.auth


sealed class AuthAction {

    data class NameChanged(val name:String) : AuthAction()
    data class LastNameChanged(val name:String): AuthAction()
    data class PhoneChanged(val phone:String): AuthAction()
    data class CodeChanged(val code:String): AuthAction()
    object CheckUser : AuthAction()
    object VerifyCode: AuthAction()
    object CompleteProfile : AuthAction()




}
