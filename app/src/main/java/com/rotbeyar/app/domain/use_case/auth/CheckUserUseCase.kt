package com.rotbeyar.app.domain.use_case.auth

import com.rotbeyar.app.domain.model.request.CheckUserRequest
import com.rotbeyar.app.domain.model.response.CheckUserResponse
import com.rotbeyar.app.domain.repository.AuthRepository
import com.rotbeyar.app.utils.AppError
import com.rotbeyar.app.utils.RotbeYarResource
import com.rotbeyar.app.utils.RotbeYarResource.*
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CheckUserUseCase@Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(request: CheckUserRequest): Flow<RotbeYarResource<CheckUserResponse>> = flow {
        emit(Loading)

        if (request.phone.isBlank()) {
        emit(Error(AppError.ClientError(400, "شماره تلفن نمی‌تواند خالی باشد.")))
        return@flow
    }


    val result: com.rotbeyar.app.data.remote.Result<CheckUserResponse> = authRepository.checkUser(request)

    when (result) {

        is com.rotbeyar.app.data.remote.Result.Success -> emit(Success(result.data))
        is com.rotbeyar.app.data.remote.Result.Error->emit(Error(result.appError))
    }
}
}