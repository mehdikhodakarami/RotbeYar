package com.rotbeyar.app.domain.repository


import com.rotbeyar.app.data.remote.Result
import com.rotbeyar.app.domain.model.Tokens
import com.rotbeyar.app.domain.model.request.CheckUserRequest
import com.rotbeyar.app.domain.model.request.VerifyPhoneRequest
import com.rotbeyar.app.domain.model.response.CheckUserResponse
import com.rotbeyar.app.domain.model.response.VerifyPhoneResponse
import com.rotbeyar.app.presentation.feture.auth.AuthStatus


interface AuthRepository {
    suspend fun saveTokens(tokens: Tokens)
     suspend fun clearTokens()
    suspend fun getAccessToken(): String?
    suspend fun getRefreshToken(): String?
    suspend fun checkUser(checkUserRequest: CheckUserRequest): Result<CheckUserResponse>
    suspend fun verifyPhone(verifyPhoneRequest: VerifyPhoneRequest): Result<VerifyPhoneResponse>
    suspend fun checkAuthStatus(): AuthStatus
    suspend fun refreshAccessToken(): Result<Tokens>

}