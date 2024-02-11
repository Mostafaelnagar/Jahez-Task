package te.app.chat.domain.use_case

import te.app.chat.domain.repository.ChatRepository
import javax.inject.Inject

class SendLocalMessageUseCase @Inject constructor(
    private val chatRepository: ChatRepository,
) {
    suspend fun sendMessage(message: String) {
        chatRepository.sendMessage(message)
    }
}

