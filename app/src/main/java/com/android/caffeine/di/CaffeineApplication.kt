package com.android.caffeine.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CaffeineApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(androidContext = this@CaffeineApplication)
            modules(viewModelModule)
        }
    }
}