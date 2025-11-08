package com.rotbeyar.app.domain.model.user

data class UserPayload(
    val userId : Long ,
    val firstName: String,
    val lastName: String,
    val email: String? = null,
    val phone: String
)