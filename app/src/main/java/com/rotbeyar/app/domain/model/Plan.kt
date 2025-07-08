package com.rotbeyar.app.domain.model

data class Plan(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val durationDays: Int
)