package com.rotbeyar.app.presentation.feture.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rotbeyar.app.data.repository.user.TokenManagerImpl
import com.rotbeyar.app.domain.model.request.CheckUserRequest
import com.rotbeyar.app.domain.model.request.UpdateProfileRequest
import com.rotbeyar.app.domain.model.request.VerifyPhoneRequest
import com.rotbeyar.app.domain.model.response.CheckUserResponse
import com.rotbeyar.app.domain.model.response.VerifyPhoneResponse
import com.rotbeyar.app.domain.use_case.GetAuthStateUseCase
import com.rotbeyar.app.domain.use_case.auth.CheckUserUseCase
import com.rotbeyar.app.domain.use_case.auth.VerifyUserUseCase
import com.rotbeyar.app.domain.use_case.user.UpdateProfileUseCase
import com.rotbeyar.app.presentation.feture.auth.events.AuthEvent
import com.rotbeyar.app.presentation.feture.auth.events.AuthEvent.*
import com.rotbeyar.app.utils.AppRegex
import com.rotbeyar.app.utils.RotbeYarResource
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.log

data class AuthUiState(
    val phoneNumber: String = "",
    val isLogined: Boolean = false,
    val firstName: String = "",
    val lastName: String = "",
    val code: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val getAuthStateUseCase: GetAuthStateUseCase,
    private val updateProfileUseCase: UpdateProfileUseCase,
    private val verifyUseCase: VerifyUserUseCase,
    private val checkUserUseCase: CheckUserUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState

    private val _uiEvent = Channel<AuthEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    fun onAction(action: AuthAction) {
        when (action) {
            is AuthAction.PhoneChanged -> {
                phoneNumberChanged(action.phone)

            }

            is AuthAction.VerifyCode -> login()
            is AuthAction.CodeChanged -> {


                codeChanged(action.code)

                if (action.code.length == 4) {
                    login()
                }
            }

            is AuthAction.LastNameChanged -> lastNameChanged(action.name)
            is AuthAction.NameChanged -> nameChanged(action.name)
            is AuthAction.CheckUser -> checkUser()
            AuthAction.CompleteProfile -> updateProfile()
        }


    }

    private fun phoneNumberChanged(phone: String) {

        if (AppRegex.isEnglishNumber(phone)) {
            _uiState.value = _uiState.value.copy(phoneNumber = phone)
        }


    }

    private fun checkUser() {
        viewModelScope.launch {
            checkUserUseCase(CheckUserRequest(phone = _uiState.value.phoneNumber)).collect { resource ->
                when (resource) {
                    is RotbeYarResource.Error -> _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = resource.error.userMessage
                        )
                    }

                    RotbeYarResource.Loading -> _uiState.update { it.copy(isLoading = true) }
                    is RotbeYarResource.Success<CheckUserResponse> -> {
                        _uiState.update { it.copy(isLoading = false, errorMessage = "",) }
                        _uiEvent.send(
                            AuthEvent.ShowSnackBar(resource.data.message)
                        )
                        _uiEvent.send(
                            AuthEvent.ShowSnackBar(resource.data.code)
                        )


                        delay(3000)
                        _uiEvent.send(AuthEvent.NavigateToVerifyCode)
                    }
                }


            }


        }


    }

    private fun codeChanged(code: String) {
        if (AppRegex.isEnglishNumber(code)) {
            _uiState.value = _uiState.value.copy(code = code)
        }

    }

    private fun login() {
        viewModelScope.launch {
            Log.i(
                "Post verify",
                "verifyCode: ${
                    VerifyPhoneRequest(
                        code = _uiState.value.code,
                        phone = _uiState.value.phoneNumber
                    )
                }"
            )
            verifyUseCase(
                VerifyPhoneRequest(
                    code = _uiState.value.code,
                    phone = _uiState.value.phoneNumber
                )
            ).collect { resource ->
                when (resource) {
                    is RotbeYarResource.Error -> _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = resource.error.userMessage
                        )

                    }

                    RotbeYarResource.Loading -> _uiState.update { it.copy(isLoading = true) }


                    is RotbeYarResource.Success<VerifyPhoneResponse> -> {

                        _uiEvent.send(
                            AuthEvent.ShowSnackBar(resource.data.message)
                        )
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = "",
                                isLogined = true

                            )
                        }


                    }
                }


            }

            checkUserStatusAfterAuth()
        }

    }


    private fun lastNameChanged(lastName: String) {
        _uiState.value = _uiState.value.copy(lastName = lastName)
    }

    private fun nameChanged(name: String) {
        _uiState.value = _uiState.value.copy(firstName = name)
    }



    private fun updateProfile(){
viewModelScope.launch {
    updateProfileUseCase(UpdateProfileRequest(_uiState.value.firstName,_uiState.value.lastName)).collect {
        resource ->
        when(resource){
            is RotbeYarResource.Error -> {

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = resource.error.userMessage
                    )
                }
                Log.i("ERror", "updateProfile:  eroooorrr called")
            }
            RotbeYarResource.Loading -> _uiState.update { it.copy(isLoading = true) }
            is RotbeYarResource.Success-> {
                Log.i("ERror", "updateProfile:  sucessss called")

                _uiState.update { it.copy(isLoading = false , errorMessage = "") }

                _uiEvent.send(AuthEvent.FinishedLogin)

            }}



    }
}
    }

    private fun checkUserStatusAfterAuth() {
        viewModelScope.launch {
            getAuthStateUseCase().collect { resource ->
                when (resource) {

                    is RotbeYarResource.Error ->TODO()

                    RotbeYarResource.Loading ->  _uiState.update { it.copy(isLoading = true) }

                    is RotbeYarResource.Success-> {
                        when(resource.data){
                            is AuthStatus.Authenticated ->{
                                _uiState.update { it.copy(isLoading = false) }
                                if(resource.data.firstName.isNullOrEmpty()){
                                    _uiEvent.send(AuthEvent.NavigateToCompleteProfile)
                                }else{
                                    _uiEvent.send(AuthEvent.FinishedLogin)
                                }

                            }
                            AuthStatus.Loading -> _uiState.update { it.copy(isLoading = true) }
                            AuthStatus.NotAuthenticated ->                                 _uiState.update { it.copy(isLoading = false) }

                            is AuthStatus.TokenExpired ->                                 _uiState.update { it.copy(isLoading = false) }

                        }
                    }

                }
            }


        }



    }

}

