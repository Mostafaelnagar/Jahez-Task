package te.app.chat.presentation.chat

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import te.app.chat.presentation.chat.view_model.ChatRoomViewModel
import te.app.chat.presentation.chat.ui.ChatBottomSection
import te.app.chat.presentation.chat.ui.ChatTopBar
import te.app.chat.presentation.chat.ui.MessagesUi

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun ChatRoomScreen(
    viewModel: ChatRoomViewModel = viewModel()
) {
    val chatFormState = viewModel.state
    val chatMessageState by viewModel.chatState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            ChatTopBar()
        },
        bottomBar = {
            ChatBottomSection(chatFormState.message,viewModel::onEvent)
        },
        content = { paddingValues ->
            if (chatMessageState.messages.isNotEmpty())
                MessagesUi(modifier = Modifier.padding(paddingValues), messages = chatMessageState.messages)

        }
    )
}
