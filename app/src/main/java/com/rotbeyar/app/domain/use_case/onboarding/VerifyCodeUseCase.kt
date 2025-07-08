package com.rotbeyar.app.domain.use_case.onboarding

import com.rotbeyar.app.domain.model.User
import com.rotbeyar.app.domain.repository.AuthRepository
import com.rotbeyar.app.utils.Resource
import com.rotbeyar.app.utils.executeUseCase
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VerifyCodeUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(phoneNumber: String, code: String): Flow<Resource<User>> {
        if (code.isBlank() || code.length != 4) {
            return flow { emit(Resource.Error("کد تایید باید ۴ رقم باشد.")) }
        }
        return executeUseCase {
            delay(1500)
            if (code == "1234") {
                authRepository.login(phoneNumber, "fake_password_from_verification")
            } else {
                throw Exception("کد تایید اشتباه است.")
            }
        }
    }
}