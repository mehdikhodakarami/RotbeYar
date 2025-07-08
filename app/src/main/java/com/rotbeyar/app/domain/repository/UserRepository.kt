package com.rotbeyar.app.domain.repository

import com.rotbeyar.app.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getStudentsForConsultant(consultantId: String): List<User>
    suspend fun getAllConsultants(): List<User>
    suspend fun getAllUsers(): List<User>
    suspend fun getUserById(userId: String): User?
    fun observeUserById(userId: String): Flow<User?>
}