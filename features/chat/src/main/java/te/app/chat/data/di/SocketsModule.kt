package te.app.chat.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import te.app.chat.data.data_source.remote.SocketWebClient
import te.app.chat.domain.repository.ChatRepository
import te.app.storage.Keys
import java.net.URI
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SocketsModule {

    @Provides
    @Singleton
    fun provideUri(): URI = URI(Keys.getSocketBaseUrl())

}