package com.rotbeyar.app.presentation.auth.actions

import com.rotbeyar.app.presentation.auth.navigation.AuthRoute

sealed class InsertPhoneNumberAction {
    object VerifyPhoneNumberBtnClicked : InsertPhoneNumberAction()
    data class PhoneNumberChanged(val phoneNumber:String) : InsertPhoneNumberAction()
}