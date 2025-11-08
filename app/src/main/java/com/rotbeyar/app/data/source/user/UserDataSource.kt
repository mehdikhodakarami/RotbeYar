package com.rotbeyar.app.data.source.user

import com.rotbeyar.app.data.remote.Result
import com.rotbeyar.app.data.remote.dto.user.request.UpdateProfileRequestDto
import com.rotbeyar.app.data.remote.dto.user.response.UpdateProfileResponseDto

interface UserDataSource {
   suspend fun updateProfile(updateProfileRequest: UpdateProfileRequestDto): Result<UpdateProfileResponseDto>
}

