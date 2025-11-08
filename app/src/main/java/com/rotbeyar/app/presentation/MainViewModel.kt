package com.rotbeyar.app.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rotbeyar.app.domain.repository.AuthRepository
import com.rotbeyar.app.domain.use_case.GetAuthStateUseCase
import com.rotbeyar.app.presentation.feture.auth.AuthStatus
import com.rotbeyar.app.utils.RotbeYarResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
   private val  getAuthStateUseCase: GetAuthStateUseCase
)  : ViewModel(){
    private val _authState = MutableStateFlow<AuthStatus>(AuthStatus.Loading)
    val authState = _authState.asStateFlow()

    init {
        checkAuthStatus()
    }


    private fun checkAuthStatus(){
        viewModelScope.launch {

            getAuthStateUseCase().collect{ res->
                when(res){
                    is RotbeYarResource.Loading -> {
                        _authState.value = AuthStatus.Loading
                    }
                    is RotbeYarResource.Success -> {
                        _authState.value = res.data
                    }
                    is RotbeYarResource.Error -> {
                        _authState.value = AuthStatus.NotAuthenticated
                    }
                }
            }
        }

    }

//    fun logout() {
//        viewModelScope.launch {
//            authRepository.clearTokens()
//            _authState.value = AuthState.Unauthenticated
//        }
//    }

}