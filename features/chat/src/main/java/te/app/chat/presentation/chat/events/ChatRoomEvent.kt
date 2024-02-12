package te.app.chat.presentation.chat.events

sealed class ChatRoomEvent {
    data class MessageBoxChanged(val message: String) : ChatRoomEvent()
    data object SendMessage : ChatRoomEvent()
}
