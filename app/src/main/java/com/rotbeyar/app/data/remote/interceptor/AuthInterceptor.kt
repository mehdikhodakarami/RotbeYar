package com.rotbeyar.app.data.remote.interceptor

import com.rotbeyar.app.data.repository.user.TokenManagerImpl
import com.rotbeyar.app.domain.repository.AuthRepository
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


class AuthInterceptor @Inject constructor(
    private val authRepository: AuthRepository
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val needsAuth =true
//            !originalRequest.url.encodedPath.contains("/auth/login") &&
//                !originalRequest.url.encodedPath.contains("/auth/register") &&
//                !originalRequest.url.encodedPath.contains("/auth/verify")

        return if (needsAuth) {
            val accessToken = runBlocking {
                authRepository.getAccessToken()
            }

            val newRequest = if (accessToken != null) {
                originalRequest.newBuilder()
                    .header("Authorization", "Bearer $accessToken")
                    .build()
            } else {
                originalRequest
            }

            chain.proceed(newRequest)
        } else {
            chain.proceed(originalRequest)
        }
    }
}