package com.rotbeyar.app.data.remote.dto.auth.response

import com.google.gson.annotations.SerializedName

data class VerifyPhoneResponseDto(
    val message: String,
//    @SerializedName("refresh_token")
    val refreshToken: String,
    val status: Int,
    val token: String
)