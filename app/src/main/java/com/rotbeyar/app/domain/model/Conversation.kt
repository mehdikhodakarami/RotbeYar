package com.rotbeyar.app.domain.model

import java.util.Date

data class Conversation(
    val id: String,
    val participants: List<Student>,
    val lastMessage: Message?,
    val unreadCount: Int = 0,
    val lastUpdated: Long = Date().time
)