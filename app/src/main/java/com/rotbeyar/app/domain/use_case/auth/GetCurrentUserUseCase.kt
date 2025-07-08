package com.rotbeyar.app.domain.use_case.auth

import com.rotbeyar.app.domain.model.User
import com.rotbeyar.app.domain.repository.AuthRepository
import com.rotbeyar.app.utils.Resource
import com.rotbeyar.app.utils.executeUseCase
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class GetCurrentUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(): Flow<Resource<User?>> {
        return executeUseCase {
            authRepository.getCurrentUser()
        }
    }

    fun observe(): Flow<Resource<User?>> {
        return authRepository.observeCurrentUser()
            .map { user -> Resource.Success(user) as Resource<User?> }
            .onStart { emit(Resource.Loading()) }
    }
}