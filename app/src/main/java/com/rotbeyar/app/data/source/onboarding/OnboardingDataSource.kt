package com.rotbeyar.app.data.source.onboarding

import com.rotbeyar.app.presentation.onboarding.model.IntroPage
import kotlinx.coroutines.flow.Flow

interface OnboardingDataSource {
    suspend fun getIntroContentLocal(): List<IntroPage>

    suspend fun setOnboardingCompletedLocal(completed: Boolean): Unit
    fun observeOnboardingCompletedLocal(): Flow<Boolean>
}