package com.rotbeyar.app.domain.model

data class Message(
    val id: String,
    val conversationId: String,
    val senderId: String,
    val senderName: String,
    val content: String,
    val timestamp: Long,
    val isMine: Boolean
)