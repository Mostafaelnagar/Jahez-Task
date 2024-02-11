package te.app.chat.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import te.app.chat.data.repository.ChatRepositoryImpl
import te.app.chat.domain.repository.ChatRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideSocketRepository(
    ): ChatRepository = ChatRepositoryImpl()


}