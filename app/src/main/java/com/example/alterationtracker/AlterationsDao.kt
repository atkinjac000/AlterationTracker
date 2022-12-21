package com.example.alterationtracker

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlterationsDao {
    @Query("Select * FROM alteration")
    suspend fun getAllAlterations(): List<Alteration>

    @Insert
    suspend fun createAlteration(alteration: Alteration): Long
}