package com.rotbeyar.app.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginRequestDto(
    @SerializedName(value = "user_name")
    val userName:String, val password:String)
