package com.rotbeyar.app.data.remote.dto

import com.rotbeyar.app.domain.model.UserRole


data class SignupRequestDto(val userName:String, val email: String, val password:String,
                            val role: UserRole
)
