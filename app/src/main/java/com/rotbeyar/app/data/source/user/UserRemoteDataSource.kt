package com.rotbeyar.app.data.source.user

import com.rotbeyar.app.data.remote.Result
import com.rotbeyar.app.data.remote.api.UserApiService
import com.rotbeyar.app.data.remote.api.safeApiCall
import com.rotbeyar.app.data.remote.dto.user.request.UpdateProfileRequestDto
import com.rotbeyar.app.data.remote.dto.user.response.UpdateProfileResponseDto
import com.rotbeyar.app.utils.ErrorHandler
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val userApiService: UserApiService,
                                               private val errorHandler: ErrorHandler
) : UserDataSource{

    override suspend fun updateProfile(updateProfileRequest: UpdateProfileRequestDto): Result<UpdateProfileResponseDto> {
        return safeApiCall(errorHandler){
            userApiService.updateProfile(updateProfileRequest.textFields,updateProfileRequest.imagePart)
        }

    }
}