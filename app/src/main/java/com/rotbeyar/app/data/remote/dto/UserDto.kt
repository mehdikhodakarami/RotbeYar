package com.rotbeyar.app.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.rotbeyar.app.domain.model.Student
import com.rotbeyar.app.domain.model.User
import com.rotbeyar.app.domain.model.UserRole

data class UserDto(
    @SerializedName("user_id") val userId: String = "",
    @SerializedName("full_name") val fullName: String = "",
    @SerializedName("user_email") val userEmail: String = "",
    @SerializedName("is_premium_plan") val isPremiumPlan: Boolean = false,
    @SerializedName("role")  val role: UserRole = UserRole.STUDENT,
    @SerializedName("auth_token") val authToken: String? = null
)
