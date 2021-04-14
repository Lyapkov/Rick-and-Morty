package com.lyapkov.rickandmorty.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RoomCharacter(
    @PrimaryKey val id: String,
    val name: String,
    val status: String,
    val species: String,
    val type: String?,
    val gender: String?,
    val image: String
)