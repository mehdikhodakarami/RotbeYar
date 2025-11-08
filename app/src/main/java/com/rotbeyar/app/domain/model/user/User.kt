package com.rotbeyar.app.domain.model.user

import com.rotbeyar.app.domain.model.subscription.StudentSubscription

data class User(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val email: String?,
    val role: UserRole,
    val subscription: StudentSubscription?,
    val relatedStudents: List<Long>? = null,

    val assignedStudents: List<Long>? = null
)