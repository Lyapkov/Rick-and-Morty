package com.lyapkov.rickandmorty.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class Info(
    @Expose val count: Int,
    @Expose val pages: Int,
    @Expose val next: String?,
    @Expose val prev: String?,
) : Parcelable