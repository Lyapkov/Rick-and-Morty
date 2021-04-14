package com.lyapkov.rickandmorty.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    @Expose val id: String,
    @Expose val name: String,
    @Expose val status: String,
    @Expose val species: String,
    @Expose val type: String?,
    @Expose val gender: String?,
    @Expose val image: String
) : Parcelable