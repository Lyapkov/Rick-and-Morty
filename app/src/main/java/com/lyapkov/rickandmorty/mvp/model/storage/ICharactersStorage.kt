package com.lyapkov.rickandmorty.mvp.model.storage

import com.lyapkov.rickandmorty.mvp.model.entity.Character
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface ICharactersStorage {
    fun putCharacters(characters: List<Character>): Completable
    fun getCharacters(): Single<List<Character>>
}