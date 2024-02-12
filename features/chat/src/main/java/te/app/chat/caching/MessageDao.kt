package te.app.chat.caching

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import te.app.chat.domain.entity.MessageItem

@Dao
interface MessageDao {
    @Query("Select * from MessageItem")
    fun getMessages(): Flow<List<MessageItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewMessage(messageItem: MessageItem)

}