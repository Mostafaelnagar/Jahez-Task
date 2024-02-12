package te.app.chat.data.data_source.local

import te.app.chat.caching.MessageDao
import te.app.chat.domain.entity.MessageItem
import javax.inject.Inject

class ChatLocalDataSource @Inject constructor(
    private val chatDao: MessageDao
) {

    fun getMessages() = chatDao.getMessages()

    fun addNewMessage(messageItem: MessageItem) = chatDao.addNewMessage(messageItem)
}