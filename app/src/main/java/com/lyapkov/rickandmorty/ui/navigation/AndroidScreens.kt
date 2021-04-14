package com.lyapkov.rickandmorty.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.lyapkov.rickandmorty.mvp.model.navigation.IScreens
import com.lyapkov.rickandmorty.ui.fragment.CharactersFragment
import com.lyapkov.rickandmorty.ui.fragment.MenuFragment

class AndroidScreens : IScreens {
    override fun menu() = FragmentScreen { MenuFragment.newInstance() }
    override fun characters() = FragmentScreen { CharactersFragment.newInstance() }
}