package com.rotbeyar.app.utils

import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

// Custom Exception Classes
sealed class AppException(message: String) : Exception(message) {
    object NetworkException : AppException("خطا در اتصال به اینترنت")
    object TimeoutException : AppException("زمان اتصال تمام شد")
    object UnauthorizedException : AppException("لطفا دوباره وارد شوید")
    object ServerException : AppException("خطا در سرور")
    object NotFoundException : AppException("داده مورد نظر یافت نشد")
    object ValidationException : AppException("اطلاعات وارد شده نامعتبر است")
    data class UnknownException(val error: String) : AppException(error)
}






object NetworkErrorHandler {
    public fun handleNetworkError(throwable: Throwable): AppException {
        return when (throwable) {
            is UnknownHostException,
            is ConnectException -> AppException.NetworkException

            is SocketTimeoutException -> AppException.TimeoutException

            is HttpException -> {
                when (throwable.code()) {
                    401 -> AppException.UnauthorizedException
                    403 -> AppException.UnauthorizedException
                    404 -> AppException.NotFoundException
                    500, 502, 503 -> AppException.ServerException
                    else -> AppException.UnknownException("خطای ناشناخته")
                }
            }

            else -> AppException.UnknownException(
                throwable.message ?: "خطای ناشناخته"
            )
        }
    }
}