package com.lyapkov.rickandmorty.di.module

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.lyapkov.rickandmorty.mvp.model.navigation.IScreens
import com.lyapkov.rickandmorty.ui.navigation.AndroidScreens
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CiceroneModule {
    val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    fun navigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

    @Provides
    fun router(): Router = cicerone.router


    @Singleton
    @Provides
    fun screens(): IScreens = AndroidScreens()

}