package com.rotbeyar.app.data.remote.dto.user.request

import android.media.Image
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Required
import okhttp3.MultipartBody
import okhttp3.RequestBody


data class UpdateProfileRequestDto(
    val textFields: Map<String, RequestBody>,
    val imagePart: MultipartBody.Part?
)