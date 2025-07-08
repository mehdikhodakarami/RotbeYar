package com.rotbeyar.app.data.remote.api

import com.rotbeyar.app.data.LoginRequest
import com.rotbeyar.app.data.LoginResponse
import com.rotbeyar.app.data.SignUpResponse
import com.rotbeyar.app.data.remote.dto.SignupRequestDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
    @POST("auth/register")
    suspend fun signup(@Body request: SignupRequestDto): SignUpResponse
}