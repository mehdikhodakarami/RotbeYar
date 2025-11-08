package com.rotbeyar.app.data.source.auth

import com.rotbeyar.app.data.remote.dto.auth.request.CheckUserRequestDto
import com.rotbeyar.app.data.remote.dto.auth.request.VerifyPhoneRequestDto
import com.rotbeyar.app.data.remote.dto.auth.response.CheckUserResponseDto
import com.rotbeyar.app.data.remote.dto.auth.response.VerifyPhoneResponseDto
import com.rotbeyar.app.data.remote.Result
import com.rotbeyar.app.data.remote.dto.auth.request.RotateRefreshTokenRequestDto
import com.rotbeyar.app.data.remote.dto.auth.response.RotateRefreshTokenResponseDto
import com.rotbeyar.app.domain.model.Tokens
import com.rotbeyar.app.domain.model.user.UserPayload


interface AuthDataSource {
suspend fun checkUser(checkUserRequest: CheckUserRequestDto): Result<CheckUserResponseDto>
    suspend fun verifyPhone(verifyPhoneRequest: VerifyPhoneRequestDto): Result<VerifyPhoneResponseDto>
    suspend fun saveTokens(tokens: Tokens)
    suspend fun getValidAccessToken(): String?
    suspend fun getUserFromToken(): UserPayload?
    suspend fun clearTokens()
    suspend fun isAuthenticated(): Boolean
    suspend fun refreshToken(rotateRefreshTokenRequest: RotateRefreshTokenRequestDto): Result<RotateRefreshTokenResponseDto>

}