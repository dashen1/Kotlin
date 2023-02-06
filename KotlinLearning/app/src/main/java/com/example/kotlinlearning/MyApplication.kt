package com.example.kotlinlearning

import android.app.Application
import com.example.kotlinlearning.database.StudentDatabase

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        StudentDatabase.getDatabase(this)
    }
}