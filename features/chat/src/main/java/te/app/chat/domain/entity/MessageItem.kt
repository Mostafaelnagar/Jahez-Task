package te.app.chat.domain.entity


data class MessageItem(
    val messageId: Int? = null,
    val message: String,
    val senderType: Int
)
