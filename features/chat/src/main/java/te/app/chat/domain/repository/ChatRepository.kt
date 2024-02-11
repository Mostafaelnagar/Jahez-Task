package te.app.chat.domain.repository

import kotlinx.coroutines.flow.Flow
import te.app.chat.domain.entity.MessageItem

interface ChatRepository {
    fun onMessageReceived(text: String)
    suspend fun sendMessage(message: String)
    fun getMessages(): Flow<List<MessageItem>>

}