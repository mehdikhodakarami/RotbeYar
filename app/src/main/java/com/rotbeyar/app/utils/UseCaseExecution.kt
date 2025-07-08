package com.rotbeyar.app.utils

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