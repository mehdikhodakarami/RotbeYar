package com.rotbeyar.app.domain.use_case.onboarding

import com.rotbeyar.app.domain.model.User
import com.rotbeyar.app.domain.repository.UserRepository
import com.rotbeyar.app.utils.Resource
import com.rotbeyar.app.utils.executeUseCase
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CompleteProfileUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(userId: String, firstName: String, lastName: String): Flow<Resource<User>> {
        if (firstName.isBlank() || lastName.isBlank()) {
            return flow { emit(Resource.Error("نام و نام خانوادگی نمی‌توانند خالی باشند.")) }
        }
        return executeUseCase {
            delay(2000)
            userRepository.getUserById(userId) ?: throw Exception("کاربر یافت نشد.")
        }
    }
}