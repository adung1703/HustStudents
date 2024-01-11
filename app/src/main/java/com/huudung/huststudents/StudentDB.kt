package com.huudung.huststudents

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "students")
data class StudentDB(
    @PrimaryKey val mssv: String,
    val name: String,
    val dateOfBirth: Date,
    val hometown: String
)
