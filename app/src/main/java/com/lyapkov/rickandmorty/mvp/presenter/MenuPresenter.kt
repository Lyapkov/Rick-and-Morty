package com.lyapkov.rickandmorty.mvp.presenter

import com.github.terrakok.cicerone.Router
import com.lyapkov.rickandmorty.mvp.model.navigation.IScreens
import com.lyapkov.rickandmorty.mvp.view.MenuView
import moxy.MvpPresenter
import javax.inject.Inject

class MenuPresenter : MvpPresenter<MenuView>() {

    @Inject
    lateinit var screens: IScreens
    @Inject
    lateinit var router: Router

    fun transitionCharacters() {
        super.onFirstViewAttach()
        router.navigateTo(screens.characters())
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}