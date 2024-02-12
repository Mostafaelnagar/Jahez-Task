package te.app.chat.presentation.chat.view_model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import te.app.chat.presentation.chat.events.ChatRoomEvent
import te.app.chat.presentation.chat.state.ChatRoomState
import te.app.chat.presentation.chat.state.ChatFormState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import te.app.chat.domain.use_case.GetMessagesUseCase
import te.app.chat.domain.use_case.SendSocketMessageUseCase
import javax.inject.Inject

@HiltViewModel
class ChatRoomViewModel @Inject constructor(
    private val getMessagesUseCase: GetMessagesUseCase,
    private val sendSocketMessageUseCase: SendSocketMessageUseCase
) : ViewModel() {

    var state by mutableStateOf(ChatFormState())

    private val _chatState =
        MutableStateFlow(ChatRoomState(isLoading = true))
    val chatState = _chatState.asStateFlow()

    init {
        getMessages()
    }

    private fun getMessages() {
        viewModelScope.launch {
            getMessagesUseCase.invoke().collect {
                _chatState.value = ChatRoomState(
                    messages =
                    it.toImmutableList()
                )
            }
        }
    }

    fun onEvent(event: ChatRoomEvent) {
        when (event) {
            is ChatRoomEvent.MessageBoxChanged -> {
                state = state.copy(
                    message = event.message,
                )
            }

            is ChatRoomEvent.SendMessage -> {
                sendMessage()
            }
        }
    }


    private fun sendMessage() {
        try {
            if (state.message.isNotEmpty())
                viewModelScope.launch {
                    sendSocketMessageUseCase.sendMessage(state.message)
                    //Reset input again
                    onEvent(ChatRoomEvent.MessageBoxChanged(""))
                }

        } catch (e: Exception) {
            Log.e("sendMessage", "sendMessage: " + e.message)
        }
    }

}
