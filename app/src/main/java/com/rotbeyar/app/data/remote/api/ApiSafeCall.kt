package com.rotbeyar.app.data.remote.api
 import com.rotbeyar.app.utils.ErrorHandler


 import retrofit2.Response
 import com.rotbeyar.app.data.remote.Result
 import com.rotbeyar.app.utils.AppError
 import retrofit2.HttpException
suspend fun <T> safeApiCall(    errorHandler: ErrorHandler,

                                apiCall: suspend () -> Response<T>
): Result<T> {
    return try {
        val response = apiCall()

        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                Result.Success(body)
            } else {
                Result.Error(AppError.DataParsingError("پاسخ سرور خالی است."))
            }
        }
        else {
            val httpException = HttpException(response)
            Result.Error(errorHandler.handle(httpException))
        }
    } catch (e: Exception) {
        Result.Error(errorHandler.handle(e))
    }
}