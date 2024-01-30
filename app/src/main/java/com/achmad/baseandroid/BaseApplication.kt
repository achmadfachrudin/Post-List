package com.achmad.baseandroid

import android.app.Application
import com.achmad.baseandroid.cache.PreferenceManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication() : Application() {

    override fun onCreate() {
        super.onCreate()

        PreferenceManager.init(this)
    }
}
