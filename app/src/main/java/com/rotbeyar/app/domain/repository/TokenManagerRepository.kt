package com.rotbeyar.app.domain.repository

import com.rotbeyar.app.domain.model.Tokens
import com.rotbeyar.app.domain.model.user.UserPayload

interface TokenManagerRepository {



        suspend fun saveTokens(tokens: Tokens)
        suspend fun getAccessToken(): String?
        suspend fun getRefreshToken(): String?
        fun isTokenExpired(token: String?): Boolean
       suspend fun decodeAccessToken(): UserPayload?
        suspend fun hasValidToken(): Boolean
        suspend fun updateAccessToken(newAccessToken: String)
        suspend fun updateRefreshToken(newRefreshToken: String)
        suspend fun clearTokens()

}