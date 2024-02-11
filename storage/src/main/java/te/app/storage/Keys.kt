package te.app.storage

object Keys {
    init {
        System.loadLibrary("native-lib")
    }

    private external fun debugBaseUrl(): String

    private external fun socketBaseUrl(): String

    fun baseUrl(): String = debugBaseUrl()
    fun getSocketBaseUrl() = socketBaseUrl()
}