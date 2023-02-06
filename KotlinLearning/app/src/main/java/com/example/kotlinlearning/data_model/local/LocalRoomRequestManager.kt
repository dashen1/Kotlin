package com.example.kotlinlearning.data_model.local

import com.example.kotlinlearning.database.Student
import com.example.kotlinlearning.database.StudentDao
import com.example.kotlinlearning.database.StudentDatabase

class LocalRoomRequestManager : ILocalRequest, IDatabaseRequest {

    var studentDao: StudentDao? = null

    init {
        val studentDatabase: StudentDatabase? = StudentDatabase.getDatabase()
        studentDao = studentDatabase?.getStudentDao()
    }

    companion object {
        var INSTANCE: LocalRoomRequestManager? = null

        fun getInstance(): LocalRoomRequestManager {
            if (INSTANCE == null) {
                synchronized(LocalRoomRequestManager::class) {
                    if (INSTANCE == null) {
                        INSTANCE = LocalRoomRequestManager()
                    }
                }
            }
            return  INSTANCE!! // !! 表明一定不为 null
        }
    }

    override fun requestInert(vararg student: Student) {
        studentDao?.insertStudents(*student)
    }

    override fun requestUpdate(vararg student: Student) {
        studentDao?.updateStudents(*student)
    }

    override fun requestDelete(vararg student: Student) {
        studentDao?.deleteStudents(*student)
    }

    override fun requestDeleteAll() {
        studentDao?.deleteAllStudents()
    }

    override fun requestQueryAll(): List<Student>? {
       return   studentDao?.queryAllStudents()
    }
}