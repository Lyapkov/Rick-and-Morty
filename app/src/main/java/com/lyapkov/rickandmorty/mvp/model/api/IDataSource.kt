package com.lyapkov.rickandmorty.mvp.model.api

import com.lyapkov.rickandmorty.mvp.model.entity.ResultCharacters
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface IDataSource {
    @GET("/api/character")
    fun getCharacters(): Single<ResultCharacters>
}