package te.app.chat.data.repository

import kotlinx.coroutines.flow.Flow
import te.app.chat.data.data_source.local.ChatLocalDataSource
import te.app.chat.domain.entity.MessageItem
import te.app.chat.domain.repository.ChatRepository
import te.app.chat.domain.utils.SenderType
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val chatLocalDataSource: ChatLocalDataSource,
) : ChatRepository {

    override  fun onMessageReceived(text: String) {
            chatLocalDataSource.addNewMessage(
                MessageItem(message = text, senderType = SenderType.RECEIVER.type)
            )
    }

    override suspend fun sendMessage(message: String) {
        chatLocalDataSource.addNewMessage(
            MessageItem(message = message, senderType = SenderType.SENDER.type)
        )
    }

    override fun getMessages(): Flow<List<MessageItem>> = chatLocalDataSource.getMessages()

}

