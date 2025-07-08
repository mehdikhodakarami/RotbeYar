package com.rotbeyar.app.data

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("user_email") val email: String,
    @SerializedName("user_password") val password: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("user_role") val role: String
)
