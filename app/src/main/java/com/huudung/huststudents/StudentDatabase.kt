package com.huudung.huststudents

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StudentDB::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
}