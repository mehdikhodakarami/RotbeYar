package com.rotbeyar.app.data.remote.dto.auth.response

data class RotateRefreshTokenResponseDto(
    val newRefreshToken: String,
    val newToken: String,
    val error: Boolean,
    val message: String,
    val success: Boolean
)