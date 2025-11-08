package com.rotbeyar.app.presentation.feture.auth.events

sealed class AuthEvent(){

    data class ShowSnackBar(val message:String):AuthEvent()
    object  NavigateToVerifyCode:AuthEvent()
    object NavigateToCompleteProfile:AuthEvent()
    object FinishedLogin: AuthEvent()


}