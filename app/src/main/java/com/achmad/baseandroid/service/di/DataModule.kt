package com.achmad.baseandroid.service.di

import com.achmad.baseandroid.service.data.AppRemote
import com.achmad.baseandroid.service.data.AppRepository
import com.achmad.baseandroid.service.data.AppService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideAppService(retrofit: Retrofit): AppService {
        return retrofit.create(AppService::class.java)
    }

    @Provides
    fun provideAppRemote(service: AppService): AppRemote {
        return AppRemote(service)
    }

    @Provides
    fun provideAppRepository(
        remote: AppRemote,
    ): AppRepository {
        return AppRepository(remote)
    }
}
