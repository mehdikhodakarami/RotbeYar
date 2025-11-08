package com.rotbeyar.app.data.source.user

import com.rotbeyar.app.data.remote.dto.user.request.UpdateProfileRequestDto
import com.rotbeyar.app.data.remote.dto.user.response.UpdateProfileResponseDto
import com.rotbeyar.app.data.remote.Result
import javax.inject.Inject


class UserLocalDataSource @Inject constructor()  : UserDataSource {
    override suspend fun updateProfile(updateProfileRequest: UpdateProfileRequestDto): Result<UpdateProfileResponseDto> {
        TODO("Not yet implemented")
    }
}