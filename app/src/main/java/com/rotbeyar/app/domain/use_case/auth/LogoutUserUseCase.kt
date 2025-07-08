package com.rotbeyar.app.domain.use_case.auth

import com.rotbeyar.app.domain.repository.AuthRepository
import com.rotbeyar.app.utils.Resource
import com.rotbeyar.app.utils.executeUseCase
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class LogoutUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(): Flow<Resource<Unit>> {
        return executeUseCase {
            authRepository.logout()
        }
    }
}