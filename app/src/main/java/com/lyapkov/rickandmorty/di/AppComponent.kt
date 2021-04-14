package com.lyapkov.rickandmorty.di

import com.lyapkov.rickandmorty.di.module.*
import com.lyapkov.rickandmorty.mvp.presenter.CharactersPresenter
import com.lyapkov.rickandmorty.mvp.presenter.MainPresenter
import com.lyapkov.rickandmorty.mvp.presenter.MenuPresenter
import com.lyapkov.rickandmorty.ui.activity.MainActivity
import com.lyapkov.rickandmorty.ui.adapter.CharactersRVAdapter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CiceroneModule::class,
        AppModule::class,
        ApiModule::class,
        RepoModule::class,
        SchedulersModule::class,
        ImageModule::class,
        StorageModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(menuPresenter: MenuPresenter)
    fun inject(charactersPresenter: CharactersPresenter)
    fun inject(charactersRVAdapter: CharactersRVAdapter)
}