package com.lyapkov.rickandmorty.di.module

import com.lyapkov.rickandmorty.ui.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app: App) {

    @Provides
    fun app(): App = app
}