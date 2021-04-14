package com.lyapkov.rickandmorty.di.module

import com.lyapkov.rickandmorty.mvp.model.api.IDataSource
import com.lyapkov.rickandmorty.mvp.model.network.INetworkStatus
import com.lyapkov.rickandmorty.mvp.model.repo.ICharactersRepo
import com.lyapkov.rickandmorty.mvp.model.repo.RetrofitCharactersRepo
import com.lyapkov.rickandmorty.mvp.model.storage.ICharactersStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun charactersRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        storage: ICharactersStorage
    ): ICharactersRepo = RetrofitCharactersRepo(api, networkStatus, storage)
}