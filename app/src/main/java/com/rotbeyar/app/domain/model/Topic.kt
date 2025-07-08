package com.rotbeyar.app.domain.model

data class Topic(
    val id: Int,
    val title: String,
    val durationSeconds: Int,
    val practiceCount: Int,
    val icon: RotbeYarIconModel
)
