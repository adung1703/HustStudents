package com.huudung.huststudents

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Query("SELECT * FROM students")
    fun getAllStudents() : ArrayList<StudentDB>

    @Insert
    fun insertStudent(student : StudentDB)

}