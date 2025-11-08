package com.rotbeyar.app.data.source.auth

import com.rotbeyar.app.data.remote.Result
import com.rotbeyar.app.data.remote.api.AuthApiService
import com.rotbeyar.app.data.remote.api.safeApiCall
import com.rotbeyar.app.data.remote.dto.auth.request.CheckUserRequestDto
import com.rotbeyar.app.data.remote.dto.auth.request.RotateRefreshTokenRequestDto
import com.rotbeyar.app.data.remote.dto.auth.request.VerifyPhoneRequestDto
import com.rotbeyar.app.data.remote.dto.auth.response.CheckUserResponseDto
import com.rotbeyar.app.data.remote.dto.auth.response.RotateRefreshTokenResponseDto
import com.rotbeyar.app.data.remote.dto.auth.response.VerifyPhoneResponseDto
import com.rotbeyar.app.domain.model.Tokens
import com.rotbeyar.app.domain.model.user.UserPayload
import com.rotbeyar.app.utils.ErrorHandler
import javax.inject.Inject

class AuthRemoteDataSource  @Inject constructor(
    private val apiService: AuthApiService,
    private val errorHandler: ErrorHandler
)  : AuthDataSource {
    override suspend fun checkUser(checkUserRequest: CheckUserRequestDto): Result<CheckUserResponseDto> {

        return safeApiCall(errorHandler){
            apiService.checkUser(checkUserRequest)
        }
    }
    override suspend fun refreshToken(rotateRefreshTokenRequest: RotateRefreshTokenRequestDto): Result<RotateRefreshTokenResponseDto> {
      return safeApiCall(errorHandler){
          apiService.rotateRefreshToken(rotateRefreshTokenRequest)
      }
    }

    override suspend fun verifyPhone(verifyPhoneRequest: VerifyPhoneRequestDto): Result<VerifyPhoneResponseDto> {
        return safeApiCall(errorHandler){
            apiService.verifyPhone(verifyPhoneRequest)

        }

    }

    override suspend fun saveTokens(tokens: Tokens) {
        TODO("Not yet implemented")
    }

    override suspend fun getValidAccessToken(): String? {
        TODO("Not yet implemented")
    }

    override suspend fun getUserFromToken(): UserPayload? {
        TODO("Not yet implemented")
    }

    override suspend fun clearTokens() {
        TODO("Not yet implemented")
    }

    override suspend fun isAuthenticated(): Boolean {
        TODO("Not yet implemented")
    }


}