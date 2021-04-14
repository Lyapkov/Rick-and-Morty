package com.lyapkov.rickandmorty.mvp.model.repo

import com.lyapkov.rickandmorty.mvp.model.api.IDataSource
import com.lyapkov.rickandmorty.mvp.model.network.INetworkStatus
import com.lyapkov.rickandmorty.mvp.model.storage.ICharactersStorage
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitCharactersRepo(
    val api: IDataSource,
    val networkStatus: INetworkStatus,
    val storage: ICharactersStorage
) : ICharactersRepo {

    override fun getCharacters() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.getCharacters().flatMap { resultCharacters ->
                storage.putCharacters(resultCharacters.results).toSingleDefault(resultCharacters.results)
            }
        } else {
             storage.getCharacters()
        }
    }.subscribeOn(Schedulers.io())
}