package com.rotbeyar.app.domain.use_case.onboarding

import com.rotbeyar.app.domain.repository.OnboardingRepository
import com.rotbeyar.app.utils.Resource
import com.rotbeyar.app.utils.executeUseCase
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SendPhoneNumberUseCase @Inject constructor(
    private val onboardingRepository: OnboardingRepository
) {
    operator fun invoke(phoneNumber: String): Flow<Resource<Unit>> {
        if (phoneNumber.isBlank() || phoneNumber.length != 11 || !phoneNumber.startsWith("09")) {
            return flow { emit(Resource.Error("فرمت شماره تلفن نامعتبر است.")) }
        }
        return executeUseCase {
//            onboardingRepository.sendPhoneNumber(phoneNumber)
        }
    }
}