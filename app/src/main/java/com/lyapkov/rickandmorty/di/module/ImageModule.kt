package com.lyapkov.rickandmorty.di.module

import android.widget.ImageView
import com.lyapkov.rickandmorty.mvp.model.image.IImageLoader
import com.lyapkov.rickandmorty.ui.image.GlideImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImageModule {
    @Singleton
    @Provides
    fun imageLoader(): IImageLoader<ImageView> = GlideImageLoader()
}