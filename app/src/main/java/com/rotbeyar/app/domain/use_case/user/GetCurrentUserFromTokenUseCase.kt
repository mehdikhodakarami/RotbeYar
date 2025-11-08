package com.rotbeyar.app.domain.use_case.user

import com.rotbeyar.app.domain.model.user.UserPayload
import com.rotbeyar.app.domain.repository.TokenManagerRepository
import javax.inject.Inject

class GetCurrentUserFromTokenUseCase @Inject constructor(
    private val tokenRepository: TokenManagerRepository
) {
    suspend operator fun invoke(): UserPayload? {
        val token = tokenRepository.getAccessToken()
        return token?.let { tokenRepository.decodeAccessToken() }
    }
}