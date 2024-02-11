package te.app.chat.data.repository

import kotlinx.coroutines.flow.Flow
import te.app.chat.domain.entity.MessageItem
import te.app.chat.domain.repository.ChatRepository
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
) : ChatRepository {
    override fun onMessageReceived(text: String) {
        TODO("Not yet implemented")
    }

    override suspend fun sendMessage(message: String) {
        TODO("Not yet implemented")
    }

    override fun getMessages(): Flow<List<MessageItem>> {
        TODO("Not yet implemented")
    }


}

