package com.rotbeyar.app.data.remote.api

import com.rotbeyar.app.data.remote.dto.user.response.UpdateProfileResponseDto
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.PartMap

interface UserApiService {
    @Multipart
    @PUT("update-profile")
    suspend fun updateProfile(
        @PartMap textFields: Map<String, @JvmSuppressWildcards RequestBody>,
        @Part image: MultipartBody.Part? = null
    ): Response<UpdateProfileResponseDto>
}

