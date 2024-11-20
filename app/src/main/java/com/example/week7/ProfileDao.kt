package com.example.week7

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProfileDao {
    @Insert
    fun insert(profile:Profile)

    @Update
    fun update(profile:Profile)

    @Delete
    fun delete(profile:Profile)

    @Query("SELECT * FROM Profile")
    fun getAll(): List<Profile>


}