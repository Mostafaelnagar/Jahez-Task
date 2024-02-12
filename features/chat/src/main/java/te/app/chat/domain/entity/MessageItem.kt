package te.app.chat.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MessageItem(
    @PrimaryKey(autoGenerate = true)
    val messageId: Int? = null,
    val message: String,
    val senderType: Int
)
