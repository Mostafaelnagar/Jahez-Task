package te.app.chat.domain.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import te.app.chat.data.data_source.remote.SocketWebClient
import javax.inject.Inject

class SendSocketMessageUseCase @Inject constructor(
    private val sendLocalMessageUseCase: SendLocalMessageUseCase,
    private val socketWebClient: SocketWebClient
) {
    suspend fun sendMessage(message: String) {
        withContext(Dispatchers.IO) {
            sendLocalMessageUseCase.sendMessage(message)
            socketWebClient.webSocketClient.send(message)
        }
    }
}

