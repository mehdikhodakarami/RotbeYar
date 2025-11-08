package com.rotbeyar.app.utils
sealed class RotbeYarResource<out T> {
    data class Success<out T>(val data: T) : RotbeYarResource<T>()
    data class Error(val error: AppError) : RotbeYarResource<Nothing>()
    data object Loading : RotbeYarResource<Nothing>()
}