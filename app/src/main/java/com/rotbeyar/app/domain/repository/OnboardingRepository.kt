package com.rotbeyar.app.domain.repository

import com.rotbeyar.app.presentation.onboarding.model.IntroPage
import kotlinx.coroutines.flow.Flow

interface OnboardingRepository {
    suspend fun getIntroPagesContent(): List<IntroPage>

    suspend fun setOnboardingCompletedStatus(completed: Boolean): Unit
    fun observeOnboardingCompletedStatus(): Flow<Boolean>
//    fun sendPhoneNumber(phoneNumber: String):Unit
}