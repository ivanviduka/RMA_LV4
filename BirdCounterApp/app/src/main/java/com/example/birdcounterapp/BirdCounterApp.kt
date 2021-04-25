package com.example.birdcounterapp

import android.app.Application
import android.content.Context
import com.example.birdcounterapp.di.appModule
import com.example.birdcounterapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BirdCounterApp: Application() {

    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin{
            androidContext(this@BirdCounterApp)
            modules(appModule, viewModelModule)
        }
    }
}