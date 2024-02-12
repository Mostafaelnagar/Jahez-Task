package te.app.chat.presentation.chat.state

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import te.app.chat.domain.entity.MessageItem

 class ChatRoomState(
    val messages: ImmutableList<MessageItem> = persistentListOf(),
    val isLoading: Boolean = false,
)
