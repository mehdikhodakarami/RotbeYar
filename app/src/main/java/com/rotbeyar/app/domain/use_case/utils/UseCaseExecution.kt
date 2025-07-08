package com.rotbeyar.app.domain.use_case.utils

import com.rotbeyar.app.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


fun <T> executeUseCase(block: suspend () -> T): Flow<Resource<T>> = flow {
    emit(Resource.Loading())
    try {
        val result = block()
        emit(Resource.Success(result))
    } catch (e: Exception) {
        emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
    }
}