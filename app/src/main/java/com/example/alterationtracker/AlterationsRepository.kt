package com.example.alterationtracker

import androidx.room.Room

object AlterationsRepository {
     private val db: AppDatabase
     private var cacheInitialized = false
     private val alterationsCache = mutableListOf<Alteration>()

     init {
         db = Room.databaseBuilder(
             AlterationApplication.getInstance(),
             AppDatabase::class.java,
             "alterations-database"
         ).build()
     }

    suspend fun createAlteration(alteration: Alteration) {
        alteration.id = db.getAlterationsDao().createAlteration(alteration)
        alterationsCache.add(alteration)
    }

    suspend fun getAllAlterations(): List<Alteration> {
        if (!cacheInitialized) {
            alterationsCache.addAll(db.getAlterationsDao().getAllAlterations())
            cacheInitialized = true
        }
        return alterationsCache
    }
}