package com.rotbeyar.app.data.remote.dto.auth.request

data class RotateRefreshTokenRequestDto(

    val oldRefreshToken: String,
    val deviceInfo : String? = null


)
