package com.rotbeyar.app.data.remote.api

import com.rotbeyar.app.data.remote.dto.auth.request.CheckUserRequestDto
import com.rotbeyar.app.data.remote.dto.auth.request.RotateRefreshTokenRequestDto
import com.rotbeyar.app.data.remote.dto.auth.request.VerifyPhoneRequestDto
import com.rotbeyar.app.data.remote.dto.auth.response.CheckUserResponseDto
import com.rotbeyar.app.data.remote.dto.auth.response.RotateRefreshTokenResponseDto
import com.rotbeyar.app.data.remote.dto.auth.response.VerifyPhoneResponseDto
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Part

interface AuthApiService {
    @POST("auth/check-user")
    suspend fun checkUser(@Body request: CheckUserRequestDto): Response<CheckUserResponseDto>
    @POST("auth/login")
    suspend fun verifyPhone(@Body request: VerifyPhoneRequestDto): Response<VerifyPhoneResponseDto>

    @POST("tokens/rotate")
    suspend fun rotateRefreshToken(
        @Body request: RotateRefreshTokenRequestDto
    ): Response<RotateRefreshTokenResponseDto>
}