package com.achmad.baseandroid.service.di

import com.achmad.baseandroid.service.data.AppRepository
import com.achmad.baseandroid.service.domain.GetPostListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideGetPostListUseCase(repository: AppRepository) = GetPostListUseCase(repository)
}
