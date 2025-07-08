package com.rotbeyar.app.data.source.auth

import com.rotbeyar.app.data.remote.api.AuthApiService
import com.rotbeyar.app.data.remote.dto.LoginRequestDto
import com.rotbeyar.app.data.remote.dto.SignupRequestDto
import com.rotbeyar.app.data.remote.dto.UserDto
import kotlinx.coroutines.flow.Flow

class AuthRemoteDataSource (authApiService: AuthApiService): AuthDataSource {
    override suspend fun login(request: LoginRequestDto): UserDto {
        TODO("Not yet implemented")
    }

    override suspend fun register(request: SignupRequestDto): UserDto {
        TODO("Not yet implemented")
    }

    override suspend fun requestPasswordReset(email: String) {
        TODO("Not yet implemented")
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }

    override suspend fun fetchUser(userId: String): UserDto? {
        TODO("Not yet implemented")
    }

    override fun observeUser(userId: String): Flow<UserDto?> {
        TODO("Not yet implemented")
    }

    override suspend fun saveAuthToken(token: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getAuthToken(): String? {
        TODO("Not yet implemented")
    }

    override suspend fun clearSession() {
        TODO("Not yet implemented")
    }
}