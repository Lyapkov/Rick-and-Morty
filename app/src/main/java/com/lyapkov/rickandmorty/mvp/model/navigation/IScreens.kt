package com.lyapkov.rickandmorty.mvp.model.navigation

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun menu(): Screen
    fun characters(): Screen
}