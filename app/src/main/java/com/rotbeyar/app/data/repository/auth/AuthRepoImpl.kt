package com.rotbeyar.app.data.repository.auth

import android.util.Log
import com.rotbeyar.app.data.mapper.toDomain
import com.rotbeyar.app.data.remote.Result
import com.rotbeyar.app.data.remote.dto.auth.request.RotateRefreshTokenRequestDto

import com.rotbeyar.app.data.source.auth.AuthLocalDataSource
import com.rotbeyar.app.data.source.auth.AuthRemoteDataSource
import com.rotbeyar.app.domain.mapper.toDto
import com.rotbeyar.app.domain.model.Tokens
import com.rotbeyar.app.domain.model.request.CheckUserRequest
import com.rotbeyar.app.domain.model.request.VerifyPhoneRequest
import com.rotbeyar.app.domain.model.response.CheckUserResponse
import com.rotbeyar.app.domain.model.response.VerifyPhoneResponse
import com.rotbeyar.app.domain.repository.AuthRepository
import com.rotbeyar.app.presentation.feture.auth.AuthStatus
import com.rotbeyar.app.utils.ErrorHandler
import javax.inject.Inject
class AuthRepoImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource,
    private val handler: ErrorHandler
) : AuthRepository {






    override suspend fun saveTokens(tokens: Tokens) {
authLocalDataSource.saveTokens(tokens)    }

    override suspend fun clearTokens() {

        authLocalDataSource.clearTokens()
    }



    override suspend fun getAccessToken(): String? {
        return authLocalDataSource.getAccessToken()
    }
    override suspend fun getRefreshToken(): String? {
        return authLocalDataSource.getRefreshToken()
    }





    override suspend fun checkUser(checkUserRequest: CheckUserRequest): Result<CheckUserResponse> {
        val result = authRemoteDataSource.checkUser(checkUserRequest.toDto())

        return when(result) {
            is Result.Error -> Result.Error(result.appError)
            is Result.Success -> Result.Success(result.data.toDomain())
        }
    }










    override suspend fun verifyPhone(verifyPhoneRequest: VerifyPhoneRequest): Result<VerifyPhoneResponse> {
        val result = authRemoteDataSource.verifyPhone(verifyPhoneRequest.toDto())

        return when(result) {
            is Result.Error -> Result.Error(result.appError)
            is Result.Success -> {
                authLocalDataSource.saveTokens(
                    Tokens(
                        accessToken = result.data.token,
                        refreshToken = result.data.refreshToken
                    )
                )
                Result.Success(result.data.toDomain())
            }
        }
    }








    override suspend fun checkAuthStatus(): AuthStatus {
        return try {
            val accessToken = authLocalDataSource.getAccessToken()

            if (accessToken.isNullOrBlank()) {
                return AuthStatus.NotAuthenticated
            }

            if (authLocalDataSource.isTokenExpired(accessToken)) {
                val refreshToken = authLocalDataSource.getRefreshToken()
                return if (refreshToken.isNullOrBlank()) {
                    AuthStatus.NotAuthenticated
                } else {
                    AuthStatus.TokenExpired(canRefresh = true)
                }
            }

            val userPayload = authLocalDataSource.decodeAccessToken()
                ?: return AuthStatus.NotAuthenticated



            AuthStatus.Authenticated(
                userId = userPayload.userId,
                phone = userPayload.phone,
                firstName = userPayload.firstName,
                lastName = userPayload.lastName,
                email = userPayload.email

            )

        } catch (e: Exception) {
            Log.e("AuthRepository", "Error checking auth status", e)
            AuthStatus.NotAuthenticated
        }
    }











    override suspend fun refreshAccessToken(): Result<Tokens> {
        return try {
            val refreshToken = authLocalDataSource.getRefreshToken()

            if (refreshToken.isNullOrBlank()) {
                authLocalDataSource.clearTokens()
                return Result.Error(
                    handler.handle(
                        Exception("Refresh token is missing"))

                )
            }

            val result = authRemoteDataSource.refreshToken(
                RotateRefreshTokenRequestDto(oldRefreshToken = refreshToken)
            )

            when(result) {
                is Result.Error -> {
                    authLocalDataSource.clearTokens()
                    Result.Error(result.appError)
                }
                is Result.Success -> {
                    authLocalDataSource.updateAccessToken(result.data.newToken)
                    authLocalDataSource.updateRefreshToken(result.data.newRefreshToken)
                    Result.Success(Tokens(result.data.newToken,result.data.newRefreshToken))
                }
            }

        } catch (e: Exception) {
            Log.e("AuthRepository", "Error refreshing token", e)
            authLocalDataSource.clearTokens()
            Result.Error(
                handler.handle(e)
            )
        }
    }

}
