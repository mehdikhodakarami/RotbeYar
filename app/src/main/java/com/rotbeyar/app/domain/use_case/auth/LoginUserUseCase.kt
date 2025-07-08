package com.rotbeyar.app.domain.use_case.auth

import android.util.Patterns
import com.rotbeyar.app.domain.model.User
import com.rotbeyar.app.domain.repository.AuthRepository
import com.rotbeyar.app.utils.Resource
import com.rotbeyar.app.utils.executeUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(private val authRepository: AuthRepository
)

{

    operator fun invoke(email: String, password: String): Flow<Resource<User>> {
        if (email.isBlank() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return flow { emit(Resource.Error("Invalid email format.")) }
        }
        if (password.length < 6) {
            return flow { emit(Resource.Error("Password must be at least 6 characters.")) }
        }

        return executeUseCase {
            authRepository.login(email, password)
        }
    }
}