package com.lyapkov.rickandmorty.mvp.model.storage.room

import com.lyapkov.rickandmorty.mvp.model.entity.Character
import com.lyapkov.rickandmorty.mvp.model.entity.room.RoomCharacter
import com.lyapkov.rickandmorty.mvp.model.entity.room.db.Database
import com.lyapkov.rickandmorty.mvp.model.storage.ICharactersStorage
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class CharactersStorage(val db: Database) : ICharactersStorage {
    override fun putCharacters(characters: List<Character>): Completable =
        Completable.fromAction {
            val roomCharacters = characters.map { character ->
                RoomCharacter(
                    character.id,
                    character.name,
                    character.status,
                    character.species,
                    character.type,
                    character.gender,
                    character.image
                )
            }
            db.characterDao.insert(roomCharacters)
        }.subscribeOn(Schedulers.io())


    override fun getCharacters(): Single<List<Character>> =
        Single.fromCallable {
            db.characterDao.getAll().map { roomCharacter ->
                Character(
                    roomCharacter.id,
                    roomCharacter.name,
                    roomCharacter.status,
                    roomCharacter.species,
                    roomCharacter.type,
                    roomCharacter.gender,
                    roomCharacter.image
                )
            }
        }.subscribeOn(Schedulers.io())
}