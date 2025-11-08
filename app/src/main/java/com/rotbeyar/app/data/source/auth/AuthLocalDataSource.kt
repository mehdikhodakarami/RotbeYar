package com.rotbeyar.app.data.source.auth

import com.rotbeyar.app.data.remote.Result
import com.rotbeyar.app.data.remote.dto.auth.request.CheckUserRequestDto
import com.rotbeyar.app.data.remote.dto.auth.request.RotateRefreshTokenRequestDto
import com.rotbeyar.app.data.remote.dto.auth.request.VerifyPhoneRequestDto
import com.rotbeyar.app.data.remote.dto.auth.response.CheckUserResponseDto
import com.rotbeyar.app.data.remote.dto.auth.response.RotateRefreshTokenResponseDto
import com.rotbeyar.app.data.remote.dto.auth.response.VerifyPhoneResponseDto
import com.rotbeyar.app.domain.model.Tokens
import com.rotbeyar.app.domain.model.user.UserPayload
import com.rotbeyar.app.domain.repository.TokenManagerRepository
import javax.inject.Inject

class AuthLocalDataSource @Inject constructor(
    private val tokenManager: TokenManagerRepository



)


    : AuthDataSource {
    override suspend fun checkUser(checkUserRequest: CheckUserRequestDto): Result<CheckUserResponseDto> {
        TODO("Not yet implemented")
    }

    override suspend fun verifyPhone(verifyPhoneRequest: VerifyPhoneRequestDto): Result<VerifyPhoneResponseDto> {
        TODO("Not yet implemented")
    }


    override suspend fun saveTokens(tokens: Tokens) {
        tokenManager.saveTokens(tokens)
    }

    override suspend fun getValidAccessToken(): String? {
        val accessToken = tokenManager.getAccessToken()

        if (accessToken.isNullOrBlank()) {
            return null
        }

        return if (tokenManager.isTokenExpired(accessToken)) {
            null
        } else {
            accessToken
        }
    }

    override suspend fun getUserFromToken(): UserPayload? {
        val accessToken = getValidAccessToken() ?: return null
        return tokenManager.decodeAccessToken()
    }

    override suspend fun isAuthenticated(): Boolean {
        return getValidAccessToken() != null
    }

    override suspend fun refreshToken(rotateRefreshTokenRequest: RotateRefreshTokenRequestDto): Result<RotateRefreshTokenResponseDto> {
        TODO("Not yet implemented")
    }

    override suspend fun clearTokens() {
        tokenManager.clearTokens()
    }

    internal suspend fun getRefreshToken(): String? {
        return tokenManager.getRefreshToken()
    }
    internal suspend fun getAccessToken(): String? {
        return tokenManager.getAccessToken()
    }

    internal suspend fun updateAccessToken(newToken: String) {
        tokenManager.updateAccessToken(newToken)
    }

 internal suspend fun updateRefreshToken(newRefreshToken: String) {
        tokenManager.updateRefreshToken(newRefreshToken)
    }


    internal  fun isTokenExpired(token: String?): Boolean {
        return tokenManager.isTokenExpired(token)
    }

    internal suspend fun decodeAccessToken(): UserPayload? {

return tokenManager.decodeAccessToken()
    }

}