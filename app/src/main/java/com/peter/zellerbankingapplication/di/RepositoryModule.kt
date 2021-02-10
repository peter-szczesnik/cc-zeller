package com.peter.zellerbankingapplication.di

import com.peter.zellerbankingapplication.repository.TransactionRepository
import com.peter.zellerbankingapplication.repository.TransactionRepository_Mock
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideTransactionRepository(
    ): TransactionRepository {
        return TransactionRepository_Mock(
        )
    }
}