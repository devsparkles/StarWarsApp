package com.devsparkle.starwarsapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devsparkle.starwarsapp.data.local.entities.PeopleEntity

@Dao
interface PeopleDao {

    @Query("SELECT * FROM peoples")
    fun getAllCharacters(): LiveData<List<PeopleEntity>>

    @Query("SELECT * FROM peoples WHERE id = :id")
    fun getCharacter(id: Int): LiveData<PeopleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(peoples: List<PeopleEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(people: PeopleEntity)


}