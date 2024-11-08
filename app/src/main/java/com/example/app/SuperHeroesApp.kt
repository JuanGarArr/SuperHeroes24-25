package com.example.app

import android.app.Application
import com.example.app.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module


class SuperHeroesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SuperHeroesApp)
            modules(AppModule().module)
        }
    }
}




