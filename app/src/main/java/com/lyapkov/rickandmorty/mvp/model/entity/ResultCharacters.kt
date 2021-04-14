package com.lyapkov.rickandmorty.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class ResultCharacters(
    @Expose val info: Info,
    @Expose val results: List<Character>
) : Parcelable