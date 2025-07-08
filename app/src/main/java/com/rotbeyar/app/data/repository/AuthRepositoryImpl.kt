package com.rotbeyar.app.data.repository

import com.rotbeyar.app.data.source.auth.AuthLocalDataSource
import com.rotbeyar.app.data.source.auth.AuthRemoteDataSource
import com.rotbeyar.app.domain.model.User
import com.rotbeyar.app.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(val remoteDataSource: AuthRemoteDataSource,val localDataSource: AuthLocalDataSource): AuthRepository{
    override suspend fun login(
        email: String,
        password: String
    ): User {
        TODO("Not yet implemented")
    }

    override suspend fun register(
        user: User,
        password: String
    ): User {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentUser(): User? {
        TODO("Not yet implemented")
    }

    override fun observeCurrentUser(): Flow<User?> {
        TODO("Not yet implemented")
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }
}