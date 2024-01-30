package com.achmad.baseandroid.di

import android.content.Context
import android.content.SharedPreferences
import com.achmad.baseandroid.cache.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(PreferenceManager.NAME, PreferenceManager.MODE)
    }
}
