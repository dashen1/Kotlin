package com.example.kotlinlearning.database

import androidx.room.*

@Dao
interface StudentDao {

    //vararg 可变参数
    //void a(String...args)
    @Insert
    fun insertStudents(vararg students: Student)

    @Update
    fun updateStudents(vararg student: Student)

    @Delete
    fun deleteStudents(vararg student: Student)

    @Query("DELETE FROM student")
    fun deleteAllStudents()

    @Query("SELECT * FROM student")
    fun queryAllStudents(): List<Student>
}