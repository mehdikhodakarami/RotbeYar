package com.rotbeyar.app.utils

import com.google.gson.JsonParseException
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException

/**
 * Sealed Class for representing all user-friendly errors in the app.
 * This class replaces raw exceptions like IOException and HttpException in higher layers.
 */
sealed class AppError(val userMessage: String) {
    class NetworkError(message: String) : AppError(message)
    class TimeoutError(message: String) : AppError(message)
    class ServerError(val code: Int, message: String) : AppError(message)
    class ClientError(val code: Int, message: String) : AppError(message)
    class UnauthorizedError(message: String) : AppError(message)
    class DataParsingError(message: String) : AppError(message)
    class SecurityError(message: String) : AppError(message)
    class CustomError(message: String) : AppError(message)
    class UnknownError(
        val devMessage: String,
        userMessage: String
    ) : AppError(userMessage)

    companion object {
        /**
         * A helper function to map a raw Throwable to a specific AppError.
         * This function centralizes the logic for error conversion.
         */
        fun fromThrowable(throwable: Throwable): AppError {
            return when (throwable) {
                is UnknownHostException, is ConnectException -> NetworkError("اتصال اینترنت برقرار نیست.")
                is SocketTimeoutException -> TimeoutError("اتصال به سرور طولانی شد. لطفاً دوباره تلاش کنید.")
                is SSLHandshakeException -> SecurityError("مشکل امنیتی در اتصال.")
                is HttpException -> when (throwable.code()) {
                    401, 403 -> UnauthorizedError(throwable.message())
                    in 400..499 -> ClientError(throwable.code(), throwable.message())
                    in 500..599 -> ServerError(throwable.code(), throwable.message())
                    else -> ServerError(throwable.code(), "خطای HTTP: ${throwable.code()}")
                }
                is JsonParseException -> DataParsingError("خطا در پردازش داده‌های سرور.")
                is IOException -> NetworkError("مشکل در خواندن یا نوشتن داده‌ها.")
                else -> UnknownError(
                    devMessage = throwable.stackTraceToString(),
                    userMessage = throwable.localizedMessage ?: "خطای ناشناخته رخ داده است."
                )
            }
        }
    }
}