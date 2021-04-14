package com.lyapkov.rickandmorty.mvp.model.repo

import com.lyapkov.rickandmorty.mvp.model.entity.Character
import com.lyapkov.rickandmorty.mvp.model.entity.ResultCharacters
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single

interface ICharactersRepo {
    fun getCharacters(): @NonNull Single<List<Character>>?
}