package com.lyapkov.rickandmorty.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler

@Module
class SchedulersModule {
    @Provides
    fun uiScheduler(): Scheduler = AndroidSchedulers.mainThread()
}