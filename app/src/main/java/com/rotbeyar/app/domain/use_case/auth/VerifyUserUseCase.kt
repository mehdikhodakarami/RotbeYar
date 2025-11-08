package com.rotbeyar.app.domain.use_case.auth

import com.rotbeyar.app.data.remote.Result
import com.rotbeyar.app.domain.model.request.VerifyPhoneRequest
import com.rotbeyar.app.domain.model.response.VerifyPhoneResponse
import com.rotbeyar.app.domain.repository.AuthRepository
import com.rotbeyar.app.domain.use_case.GetAuthStateUseCase
import com.rotbeyar.app.utils.AppError
import com.rotbeyar.app.utils.RotbeYarResource.*

import com.rotbeyar.app.utils.RotbeYarResource
import com.rotbeyar.app.utils.RotbeYarResource.Error
import com.rotbeyar.app.utils.RotbeYarResource.Success
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VerifyUserUseCase @Inject constructor(
    private val authRepository: AuthRepository,

) {



    operator fun invoke(request: VerifyPhoneRequest): Flow<RotbeYarResource<VerifyPhoneResponse>> = flow {
    emit(Loading)

    if (request.code.isBlank()) {
        emit(Error(AppError.ClientError(400, "کد نمی‌تواند خالی باشد.")))
        return@flow
    }


    val result: Result<VerifyPhoneResponse> = authRepository.verifyPhone(request)

    when (result) {

        is Result.Success -> {

            authRepository.saveTokens(result.data.tokens)
            emit(Success(result.data))
        }
        is Result.Error->emit(Error(result.appError))
    }
}
}