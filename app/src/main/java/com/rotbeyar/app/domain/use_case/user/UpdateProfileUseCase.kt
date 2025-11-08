package com.rotbeyar.app.domain.use_case.user

import com.rotbeyar.app.data.remote.Result
import com.rotbeyar.app.domain.model.request.UpdateProfileRequest
import com.rotbeyar.app.domain.model.response.UpdateProfileResponse
import com.rotbeyar.app.domain.repository.UserRepository
import com.rotbeyar.app.utils.AppError
import com.rotbeyar.app.utils.RotbeYarResource
import com.rotbeyar.app.utils.RotbeYarResource.Error
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateProfileUseCase @Inject constructor(
    private val userRepository: UserRepository
)  {

    operator fun invoke(updateProfileRequest: UpdateProfileRequest) : Flow<RotbeYarResource<UpdateProfileResponse>> = flow {
        if(updateProfileRequest.firstName.isBlank() || updateProfileRequest.lastName.isBlank()){
            emit(RotbeYarResource.Error(AppError.ClientError(400, "لطفا تمام فیلد های ورودی را پر کنید")))
            return@flow
        }
        emit(RotbeYarResource.Loading)

        val result = userRepository.updateProfile(updateProfileRequest)
        when(result){
            is Result.Error -> emit(Error(result.appError))
            is Result.Success -> emit(RotbeYarResource.Success(result.data))
        }








    }
}