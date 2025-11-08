package com.rotbeyar.app.data.mapper

import com.rotbeyar.app.data.remote.dto.user.response.UpdateProfileResponseDto
import com.rotbeyar.app.domain.model.response.UpdateProfileResponse

fun UpdateProfileResponseDto.toDomain(): UpdateProfileResponse {
    return UpdateProfileResponse(this.success, this.error, this.message)
}