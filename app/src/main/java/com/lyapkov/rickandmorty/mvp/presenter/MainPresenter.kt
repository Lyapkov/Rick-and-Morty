package com.lyapkov.rickandmorty.mvp.presenter

import com.github.terrakok.cicerone.Router
import com.lyapkov.rickandmorty.mvp.model.navigation.IScreens
import com.lyapkov.rickandmorty.mvp.view.MainView
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.menu())
    }

    fun backClicked() {
        router.exit()
    }
}