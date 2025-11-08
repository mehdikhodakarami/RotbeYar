package com.rotbeyar.app.data.remote.dto.auth.request

import com.google.gson.annotations.SerializedName

data class VerifyPhoneRequestDto(

@SerializedName("phone")
    val phoneNumber: String,
@SerializedName("code")

    val code:String
    )