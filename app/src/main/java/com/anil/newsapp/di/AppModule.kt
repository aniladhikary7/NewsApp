package com.anil.newsapp.di

import android.app.Application
import com.anil.newsapp.data.LocalUserMangerImpl
import com.anil.newsapp.domain.manager.LocalUserManger
import com.anil.newsapp.domain.usecases.AppEntryUseCases
import com.anil.newsapp.domain.usecases.ReadAppEntry
import com.anil.newsapp.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

}