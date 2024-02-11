package app.te.jahez.core.di.module

import app.te.navigation.NavigationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppsModule {

    @Provides
    @Singleton
    fun providesNavigationManager() =
        NavigationManager()


}