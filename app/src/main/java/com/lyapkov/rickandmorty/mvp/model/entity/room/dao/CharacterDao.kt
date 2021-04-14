package com.lyapkov.rickandmorty.mvp.model.entity.room.dao

import androidx.room.*
import com.lyapkov.rickandmorty.mvp.model.entity.room.RoomCharacter

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(character: RoomCharacter)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg characters: RoomCharacter)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(characters: List<RoomCharacter>)

    @Update
    fun update(character: RoomCharacter)

    @Update
    fun update(vararg characters: RoomCharacter)

    @Update
    fun update(characters: List<RoomCharacter>)

    @Delete
    fun delete(character: RoomCharacter)

    @Delete
    fun delete(vararg characters: RoomCharacter)

    @Delete
    fun delete(character: List<RoomCharacter>)

    @Query("SELECT * FROM RoomCharacter")
    fun getAll(): List<RoomCharacter>

    @Query("SELECT * FROM RoomCharacter WHERE name = :name LIMIT 1")
    fun findByLogin(name: String): RoomCharacter?
}