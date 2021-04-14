package com.lyapkov.rickandmorty.mvp.view.list

interface CharacterItemView : IItemView {
    fun setName(text: String)
    fun setStatus(text: String)
    fun setSpecies(text: String)
    fun setType(text: String?)
    fun setGender(text: String?)
    fun loadAvatar(url: String)
}