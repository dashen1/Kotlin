package com.example.kotlinlearning.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun getStudentDao(): StudentDao

    companion object {
        private var INSTANCE : StudentDatabase ? = null

        // 后缀名有java的话表示调用的是java类
        fun getDatabase(context: Context) : StudentDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, StudentDatabase::class.java, "student.database.db")
                    .allowMainThreadQueries() //允许在主线程运行
                    .build()
            }
            return INSTANCE
        }

        fun getDatabase() : StudentDatabase? = INSTANCE
    }
}