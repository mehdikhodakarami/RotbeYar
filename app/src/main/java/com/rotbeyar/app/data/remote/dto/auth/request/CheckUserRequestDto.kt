package com.rotbeyar.app.data.remote.dto.auth.request

import com.google.gson.annotations.SerializedName

data class CheckUserRequestDto(
    @SerializedName("phone")

    val phone:String
)