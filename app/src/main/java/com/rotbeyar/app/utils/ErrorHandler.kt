package com.rotbeyar.app.utils
import com.google.gson.JsonParseException
import retrofit2.HttpException
import java.io.IOException
import java.net.*
import javax.inject.Inject
import javax.net.ssl.SSLHandshakeException

class ErrorHandler @Inject constructor() {

    fun handle(throwable: Throwable): AppError {
        return when (throwable) {

            is UnknownHostException -> AppError.NetworkError("اتصال اینترنت برقرار نیست یا DNS در دسترس نیست.")
            is ConnectException -> AppError.NetworkError("اتصال به سرور برقرار نشد.")
            is SocketTimeoutException -> AppError.TimeoutError("اتصال به سرور طولانی شد. لطفاً دوباره تلاش کنید.")
            is SSLHandshakeException -> AppError.SecurityError("مشکل در احراز هویت SSL. لطفاً نسخه اپ را بررسی کنید.")

            is HttpException -> handleHttpError(throwable)

            is JsonParseException -> AppError.DataParsingError("خطا در پردازش داده‌های سرور.")

            is IOException -> AppError.NetworkError("مشکل در خواندن یا نوشتن داده‌ها. لطفاً بعداً امتحان کنید.")

            is AppException -> AppError.CustomError(throwable.message ?: "خطای داخلی برنامه.")


            else -> AppError.UnknownError(
                devMessage = throwable.stackTraceToString(),
                userMessage = throwable.localizedMessage ?: "خطای ناشناخته رخ داده است."
            )
        }
    }

    private fun handleHttpError(e: HttpException): AppError {
        val code = e.code()
        return when (code) {
            400 -> AppError.ClientError(code, e.message ?:"درخواست اشتباه ارسال شده است")
            401 -> AppError.UnauthorizedError("دسترسی غیرمجاز. لطفاً وارد شوید.")
            403 -> AppError.UnauthorizedError("شما مجاز به انجام این عملیات نیستید.")
            404 -> AppError.ClientError(code, "منبع درخواستی پیدا نشد.")
            in 500..599 -> AppError.ServerError(code, "خطای سمت سرور. لطفاً بعداً تلاش کنید.")
            else -> AppError.ServerError(code, "خطای HTTP: $code")
        }
    }
}