package com.lyapkov.rickandmorty.ui

import android.app.Application
import com.lyapkov.rickandmorty.di.AppComponent
import com.lyapkov.rickandmorty.di.DaggerAppComponent
import com.lyapkov.rickandmorty.di.module.AppModule

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}