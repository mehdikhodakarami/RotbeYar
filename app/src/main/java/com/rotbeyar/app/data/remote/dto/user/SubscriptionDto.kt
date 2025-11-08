package com.rotbeyar.app.data.remote.dto.user

import com.google.gson.annotations.SerializedName

data class SubscriptionDto(

    @SerializedName("type")
    val type: String,  // "FREE", "BASIC", "PREMIUM", "VIP"

    @SerializedName("is_active")
    val isActive: Boolean,

    @SerializedName("start_date")
    val startDate: Long,

    @SerializedName("expiry_date")
    val expiryDate: Long?,

    @SerializedName("is_auto_renew")
    val isAutoRenew: Boolean,

    // ⭐ ویژگی‌های این اشتراک
    @SerializedName("features")
    val features: List<String>,  // ["BASIC_CONTENT", "DOWNLOAD", ...]

    @SerializedName("limits")
    val limits: SubscriptionLimitsDto?
)