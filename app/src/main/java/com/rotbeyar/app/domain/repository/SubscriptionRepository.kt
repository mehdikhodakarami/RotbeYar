package com.rotbeyar.app.domain.repository

import com.rotbeyar.app.domain.model.Plan
import com.rotbeyar.app.domain.model.User
import kotlinx.coroutines.flow.Flow

interface SubscriptionRepository {
    suspend fun getAvailablePlans(): List<Plan>
    suspend fun purchasePlan(planId: String, userId: String): Boolean
//    fun getUserSubscriptionStatus(userId: String): Flow<User.SubscriptionStatus> // مثلا یک وضعیت برای پلن
}