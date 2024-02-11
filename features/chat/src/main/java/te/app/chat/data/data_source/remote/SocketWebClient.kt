package te.app.chat.data.data_source.remote

import dev.gustavoavila.websocketclient.WebSocketClient
import te.app.chat.domain.repository.ChatRepository
import te.app.storage.Keys
import java.lang.Exception
import java.net.URI
import javax.inject.Inject

class SocketWebClient @Inject constructor(
    private val chatRepository: ChatRepository
) {
    private lateinit var webSocketClient: WebSocketClient

    init {
        provideWebClientSocket()
    }

    private fun provideWebClientSocket() {
        webSocketClient = object : WebSocketClient(URI(Keys.getSocketBaseUrl())) {
            override fun onOpen() {
            }

            override fun onTextReceived(message: String?) {
                if (!message.isNullOrEmpty()) {
                    chatRepository.onMessageReceived(text = message)
                }
            }

            override fun onBinaryReceived(data: ByteArray?) {

            }

            override fun onPingReceived(data: ByteArray?) {

            }

            override fun onPongReceived(data: ByteArray?) {

            }

            override fun onException(e: Exception?) {
            }

            override fun onCloseReceived(reason: Int, description: String?) {

            }

        }
        webSocketClient.setConnectTimeout(10000)
        webSocketClient.setReadTimeout(60000)
        webSocketClient.enableAutomaticReconnection(5000)
        webSocketClient.connect()

    }

}