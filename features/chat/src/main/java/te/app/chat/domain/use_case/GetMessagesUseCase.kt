package te.app.chat.domain.use_case

import te.app.chat.domain.repository.ChatRepository
import javax.inject.Inject

class GetMessagesUseCase @Inject constructor(
    private val chatRepository: ChatRepository
) {
    operator fun invoke() = chatRepository.getMessages()

}