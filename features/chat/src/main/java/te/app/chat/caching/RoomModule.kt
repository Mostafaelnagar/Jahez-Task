package te.app.chat.caching

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import te.app.chat.data.data_source.local.ChatLocalDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideMyDB(@ApplicationContext context: Context): ChatDatabase {
        return Room.databaseBuilder(
            context,
            ChatDatabase::class.java,
            "chatDb"
        ).build()
    }

    @Provides
    @Singleton
    fun provideChatSource(db: ChatDatabase): ChatLocalDataSource {
        return ChatLocalDataSource(db.messageDao)
    }
}