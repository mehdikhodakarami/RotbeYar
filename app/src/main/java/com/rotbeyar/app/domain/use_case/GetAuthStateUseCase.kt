package com.rotbeyar.app.domain.use_case

import com.rotbeyar.app.domain.repository.AuthRepository
import com.rotbeyar.app.presentation.feture.auth.AuthStatus
import com.rotbeyar.app.utils.RotbeYarResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAuthStateUseCase @Inject constructor(private val authRepository: AuthRepository) {


    operator fun invoke () : Flow<RotbeYarResource<AuthStatus>> = flow {
        emit(RotbeYarResource.Loading)

        val authState = authRepository.checkAuthStatus()

       emit(RotbeYarResource.Success(authState))


    }
}