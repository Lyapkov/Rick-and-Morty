package com.lyapkov.rickandmorty.di.module

import androidx.room.Room
import com.lyapkov.rickandmorty.mvp.model.entity.room.db.Database
import com.lyapkov.rickandmorty.mvp.model.storage.ICharactersStorage
import com.lyapkov.rickandmorty.mvp.model.storage.room.CharactersStorage
import com.lyapkov.rickandmorty.ui.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {
    @Singleton
    @Provides
    fun database(app: App) =
        Room.databaseBuilder(app, Database::class.java, Database.DB_NAME).build()

    @Singleton
    @Provides
    fun charactersStorage(db: Database): ICharactersStorage = CharactersStorage(db)
}