package com.example.alterationtracker

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Alteration::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getAlterationsDao(): AlterationsDao
}