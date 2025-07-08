package com.rotbeyar.app.domain.repository

import com.rotbeyar.app.domain.model.User
import kotlinx.coroutines.flow.Flow


interface AuthRepository {
    suspend fun login(email: String, password: String): User
    suspend fun register(user: User, password: String): User
    suspend fun getCurrentUser(): User?

    fun observeCurrentUser(): Flow<User?>

    suspend fun logout(): Unit
}