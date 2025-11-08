package com.rotbeyar.app.data.remote

import com.rotbeyar.app.utils.AppError

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val appError: AppError) : Result<Nothing>()

}