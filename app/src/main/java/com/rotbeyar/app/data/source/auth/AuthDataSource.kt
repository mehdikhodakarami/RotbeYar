package com.rotbeyar.app.data.source.auth

import com.rotbeyar.app.data.remote.dto.LoginRequestDto
import com.rotbeyar.app.data.remote.dto.SignupRequestDto
import com.rotbeyar.app.data.remote.dto.UserDto
import kotlinx.coroutines.flow.Flow


interface AuthDataSource {


    suspend fun login(request: LoginRequestDto): UserDto


    suspend fun register(request: SignupRequestDto): UserDto


    suspend fun requestPasswordReset(email: String): Unit


    suspend fun logout(): Unit

    suspend fun fetchUser(userId: String): UserDto?

    fun observeUser(userId: String): Flow<UserDto?>


//    suspend fun saveUser(user: UserEntity)


//    fun getLocalUser(userId: String): Flow<UserEntity?>


    suspend fun saveAuthToken(token: String)


    suspend fun getAuthToken(): String?


    suspend fun clearSession()
}