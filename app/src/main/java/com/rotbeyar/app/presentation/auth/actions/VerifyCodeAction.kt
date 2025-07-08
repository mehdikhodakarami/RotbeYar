package com.rotbeyar.app.presentation.auth.actions

sealed class VerifyCodeAction {
    data class CodeChanged(val code : String) : VerifyCodeAction()
    object VerifyCodeBtnClicked: VerifyCodeAction()
}