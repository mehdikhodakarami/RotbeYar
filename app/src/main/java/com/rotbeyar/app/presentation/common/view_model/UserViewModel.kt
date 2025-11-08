package com.rotbeyar.app.presentation.common.view_model

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rotbeyar.app.domain.model.request.UpdateProfileRequest
import com.rotbeyar.app.domain.use_case.user.UpdateProfileUseCase
import com.rotbeyar.app.utils.RotbeYarResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject


data class ProfileState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val phone: String = "",
    val image : File? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)


sealed class ProfileAction {
    data class PhoneNumberChanged(val phone : String) : ProfileAction()
    data class FirstNameChanged(val firstName: String) : ProfileAction()
    data class LastNameChanged(val lastName: String) : ProfileAction()
    data class EmailChanged(val email: String) : ProfileAction()
    data class ImageSelected(val uri: Uri) : ProfileAction()
    object UpdateProfile : ProfileAction()
}
@HiltViewModel
class UserViewModel @Inject constructor(

    private val updateProfileUseCase: UpdateProfileUseCase
) : ViewModel() {


    private val _uiProfileState = MutableStateFlow(ProfileState())
    val uiProfileState = _uiProfileState.asStateFlow()

    fun onProfileAction(action : ProfileAction){
        when(action){
            is ProfileAction.EmailChanged -> TODO()
            is ProfileAction.FirstNameChanged -> TODO()
            is ProfileAction.ImageSelected -> TODO()
            is ProfileAction.LastNameChanged -> TODO()
            ProfileAction.UpdateProfile -> TODO()
            is ProfileAction.PhoneNumberChanged -> TODO()
        }

    }


    fun updateProfile() {
viewModelScope.launch{
    updateProfileUseCase(UpdateProfileRequest(
        firstName = _uiProfileState.value.firstName,
        lastName = _uiProfileState.value.lastName,
        email = _uiProfileState.value.email,
        phone = _uiProfileState.value.phone


    )).collect { resource ->

        when(resource){
            is RotbeYarResource.Error -> _uiProfileState.update { it.copy (isLoading = false,errorMessage = resource.error.userMessage) }
            RotbeYarResource.Loading -> _uiProfileState.update{it.copy(isLoading = true)}
            is RotbeYarResource.Success -> {
                _uiProfileState.update{it.copy(isLoading = false, errorMessage = "",)}
            }
        }


    }
}
    }
    fun emailChanged(email :String){

    }
    fun firstNameChanged(firstName :String){

    }
    fun lastNameChanged(lastName :String){

    }
    fun imageSelected(uri :Uri){

    }



}