package com.rotbeyar.app.data

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    val token: String,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("message")
    val message: String? = null
)