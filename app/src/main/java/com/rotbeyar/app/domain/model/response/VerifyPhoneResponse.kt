package com.rotbeyar.app.domain.model.response

import com.rotbeyar.app.domain.model.Tokens

data class VerifyPhoneResponse(
    val message: String,
    val status: Int,
    val tokens: Tokens
)