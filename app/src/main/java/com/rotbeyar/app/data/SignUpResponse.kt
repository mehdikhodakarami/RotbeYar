package com.rotbeyar.app.data

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("token")
                            val token: String,
                            @SerializedName("user_id")
                            val userId: String,
                            @SerializedName("message")
                            val message: String? = null)
