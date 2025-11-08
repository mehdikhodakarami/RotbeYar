package com.rotbeyar.app.domain.repository

import com.rotbeyar.app.data.remote.Result
import com.rotbeyar.app.domain.model.request.UpdateProfileRequest
import com.rotbeyar.app.domain.model.response.UpdateProfileResponse

interface UserRepository {

    suspend fun updateProfile(updateProfileRequest: UpdateProfileRequest)  : Result<UpdateProfileResponse>
}