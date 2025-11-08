package com.rotbeyar.app.domain.model.request

import java.io.File

data class UpdateProfileRequest(
    val firstName: String,
    val lastName: String,
    val email: String? =null,
    val phone: String? =null,
    val imageFile: File? = null

)
