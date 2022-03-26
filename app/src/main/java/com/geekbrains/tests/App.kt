package com.geekbrains.tests

import android.app.Application
import com.geekbrains.tests.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }

    companion object {
        const val BASE_URL = "https://api.github.com"
    }
}