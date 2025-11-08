package com.rotbeyar.app.domain.model.request

data class VerifyPhoneRequest(
    val phone : String,
    val code : String
)
