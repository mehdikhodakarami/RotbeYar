package com.rotbeyar.app.data.remote
import com.rotbeyar.app.data.remote.api.AuthApiService
import com.rotbeyar.app.data.remote.dto.auth.request.RotateRefreshTokenRequestDto
import com.rotbeyar.app.data.repository.user.TokenManagerImpl
import com.rotbeyar.app.domain.model.Tokens
import com.rotbeyar.app.domain.repository.AuthRepository
import javax.inject.Inject
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Named

class TokenAuthenticator @Inject constructor(

private val authRepository: AuthRepository   ,
private val refreshAuthApi: AuthApiService
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        if (responseCount(response) >= 3) {
            runBlocking { authRepository.clearTokens() }
            return null
        }

        if (response.priorResponse != null &&
            response.priorResponse?.request?.header("Authorization") != null
        ) {
            return null
        }

        if (response.code == 401) {
          return runBlocking {
              when(val result = authRepository.refreshAccessToken()){
                  is Result.Error ->  null
                  is Result.Success ->{
                      response.request.newBuilder()
                          .header("Authorization", "Bearer ${result.data.accessToken}")
                          .build()
                  }
              }
          }




            }
        else {
                return null
            }


    }
    private fun responseCount(response: Response): Int {
        var count = 1
        var prior = response.priorResponse
        while (prior != null) {
            count++
            prior = prior.priorResponse
        }
        return count
    }
}