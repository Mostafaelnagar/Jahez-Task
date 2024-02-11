package te.app.chat.caching

import androidx.room.Database
import androidx.room.RoomDatabase
import te.app.chat.domain.entity.MessageItem

@Database(
    entities = [MessageItem::class],
    version = 1, exportSchema = false
)

abstract class ChatDatabase : RoomDatabase() {
    abstract val messageDao: MessageDao
}