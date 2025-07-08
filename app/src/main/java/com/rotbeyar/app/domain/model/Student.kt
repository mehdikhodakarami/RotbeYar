package com.rotbeyar.app.domain.model

import retrofit2.http.Url

data class Student(
    val id: String,
    val name: String,
    val email: String,
    @Url val profilePictureUrl: String?,
    val planExpiryDate: Long?,
    val isActive: Boolean,

    val firstName: String,
    val lastName: String,
    val birthDate: String,
    val gender: Gender,
    val grade: String,
    val major:String,
    val phoneNumber: String?,
    val address: String?,
    val createdAt: Long,
    val updatedAt: Long,
    val parents: List<Parent>

)
enum class Gender {
    MALE, FEMALE
}
enum class UserRole {
    STUDENT,CONSULTANT, MANAGER
}



