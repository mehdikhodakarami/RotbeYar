package com.rotbeyar.app.presentation.auth.actions

sealed class InsertNameAction {
    object SignUpBtnClicked : InsertNameAction()
    data class NameValueChanged(val name:String)
    data class LastNameValueChanged(val lastName:String)

}