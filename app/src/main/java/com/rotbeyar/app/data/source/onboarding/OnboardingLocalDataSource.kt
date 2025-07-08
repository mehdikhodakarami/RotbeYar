package com.rotbeyar.app.data.source.onboarding

import com.rotbeyar.app.presentation.onboarding.model.IntroPage
import kotlinx.coroutines.flow.Flow

class OnboardingLocalDataSource():OnboardingDataSource {
    override suspend fun getIntroContentLocal(): List<IntroPage> {
        TODO("Not yet implemented")
    }

    override suspend fun setOnboardingCompletedLocal(completed: Boolean) {
        TODO("Not yet implemented")
    }

    override fun observeOnboardingCompletedLocal(): Flow<Boolean> {
        TODO("Not yet implemented")
    }
}