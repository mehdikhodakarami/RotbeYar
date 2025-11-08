package com.rotbeyar.app.domain.mapper

import com.rotbeyar.app.data.remote.dto.auth.request.CheckUserRequestDto
import com.rotbeyar.app.data.remote.dto.auth.request.RotateRefreshTokenRequestDto
import com.rotbeyar.app.data.remote.dto.auth.request.VerifyPhoneRequestDto
import com.rotbeyar.app.data.remote.dto.user.request.UpdateProfileRequestDto
import com.rotbeyar.app.domain.model.request.CheckUserRequest
import com.rotbeyar.app.domain.model.request.RefreshTokenRotateRequest
import com.rotbeyar.app.domain.model.request.UpdateProfileRequest
import com.rotbeyar.app.domain.model.request.VerifyPhoneRequest
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody

fun CheckUserRequest.toDto() : CheckUserRequestDto {
return CheckUserRequestDto(this.phone)
}

fun VerifyPhoneRequest.toDto() : VerifyPhoneRequestDto {
    return VerifyPhoneRequestDto(this.phone,this.code)
}
fun RefreshTokenRotateRequest.toDto() : RotateRefreshTokenRequestDto {
    return RotateRefreshTokenRequestDto(this.oldRefreshToken,"")
}

fun UpdateProfileRequest.toDto(): UpdateProfileRequestDto {
    val textFields = buildMap<String, RequestBody> {
        put("first_name", firstName.toRequestBody("text/plain".toMediaTypeOrNull()))
        put("last_name", lastName.toRequestBody("text/plain".toMediaTypeOrNull()))
        email?.takeIf { it.isNotBlank() }?.let { put("email", email.toRequestBody("text/plain".toMediaTypeOrNull())) }
        phone?.takeIf { it.isNotBlank() }?.let {  put("phone", phone.toRequestBody("text/plain".toMediaTypeOrNull()))}

    }

    val imagePart = imageFile?.let {
        MultipartBody.Part.createFormData(
            "image",
            it.name,
            it.asRequestBody("image/*".toMediaTypeOrNull())
        )
    }

    return UpdateProfileRequestDto(textFields, imagePart)
}




