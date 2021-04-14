package com.lyapkov.rickandmorty.mvp.model.image

interface IImageLoader<T> {
    fun loadInto(url:String, container: T)
}