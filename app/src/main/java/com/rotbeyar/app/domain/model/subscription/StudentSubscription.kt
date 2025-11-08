package com.rotbeyar.app.domain.model.subscription

import com.google.android.gms.common.Feature

data class StudentSubscription(
    val type: SubscriptionType?,
    val status: SubscriptionStatus,
    val expiresAt: String? = null,
    val startDate: Long,
    val expiryDate: Long?,
    val daysRemaining: Int
)