package com.rotbeyar.app.presentation.auth

import androidx.lifecycle.ViewModel
import com.rotbeyar.app.presentation.auth.actions.InsertPhoneNumberAction
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow

data class AuthUiState(val phoneNumber:String="",
                       val name:String = "",
    val lastName : String = ""
    )

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel(){
    val _uiState = MutableStateFlow(AuthUiState())


    fun onActionPhoneNumber(action: InsertPhoneNumberAction){
        when(action){
            is InsertPhoneNumberAction.PhoneNumberChanged -> phoneNumberChanged(action.phoneNumber)
            InsertPhoneNumberAction.VerifyPhoneNumberBtnClicked -> sendCode()
        }

    }
    fun onActionVerifyCode(){

    }

    fun onActionInsertInsertName(){

    }


    fun phoneNumberChanged(phoneNumber:String){

    }
    fun sendCode(){
        _uiState.value.phoneNumber
    }

}