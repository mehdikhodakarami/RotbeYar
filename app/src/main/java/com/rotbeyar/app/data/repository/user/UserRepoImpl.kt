package com.rotbeyar.app.data.repository.user

import com.rotbeyar.app.data.mapper.toDomain
import com.rotbeyar.app.data.remote.Result
import com.rotbeyar.app.data.source.user.UserLocalDataSource
import com.rotbeyar.app.data.source.user.UserRemoteDataSource
import com.rotbeyar.app.domain.mapper.toDto
import com.rotbeyar.app.domain.model.request.UpdateProfileRequest
import com.rotbeyar.app.domain.model.response.UpdateProfileResponse
import com.rotbeyar.app.domain.repository.UserRepository
import javax.inject.Inject

class UserRepoImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource
) : UserRepository {
    override suspend fun updateProfile(updateProfileRequest: UpdateProfileRequest) : Result<UpdateProfileResponse> {
val result = userRemoteDataSource.updateProfile(updateProfileRequest.toDto())

        return when(result){
            is Result.Error -> Result.Error(result.appError)
            is Result.Success -> Result.Success(result.data.toDomain())

        }

    }
}