package com.example.alterationtracker

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Alteration (
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo var customerName: String,
    @ColumnInfo var suitAlterations: String,
    @ColumnInfo var pantAlterations: String
)