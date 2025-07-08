package com.rotbeyar.app.domain.repository

import com.rotbeyar.app.domain.model.Conversation
import com.rotbeyar.app.domain.model.Message
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    /**
     * Sends a new message.
     * @param conversationId The ID of the conversation.
     * @param message The message to send.
     */
    suspend fun sendMessage(conversationId: String, message: Message)

    /**
     * Observes real-time messages for a specific conversation.
     * @param conversationId The ID of the conversation.
     * @return A Flow of a list of messages.
     */
    fun observeMessages(conversationId: String): Flow<List<Message>>

    /**
     * Retrieves the list of all conversations for the current user.
     * @param userId The ID of the current user.
     * @return A Flow of a list of conversations.
     */
    fun observeConversations(userId: String): Flow<List<Conversation>>

    /**
     * Fetches a specific conversation by its ID.
     * @param conversationId The ID of the conversation.
     * @return The Conversation domain model, or null if not found.
     */
    suspend fun getConversationById(conversationId: String): Conversation?

    // You can add more methods such as createConversation, deleteMessage, etc.
}