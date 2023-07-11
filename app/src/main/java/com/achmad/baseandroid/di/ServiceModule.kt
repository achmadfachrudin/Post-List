package com.achmad.baseandroid.di

import com.achmad.baseandroid.service.PostRemote
import com.achmad.baseandroid.service.PostRepository
import com.achmad.baseandroid.service.PostService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun providePostService(retrofit: Retrofit): PostService {
        return retrofit.create(PostService::class.java)
    }

    @Provides
    @Singleton
    fun providePostRemote(service: PostService): PostRemote {
        return PostRemote(service)
    }

    @Provides
    fun providePostRepository(
        remote: PostRemote,
    ): PostRepository {
        return PostRepository(remote)
    }
}
