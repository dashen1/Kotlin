package com.example.kotlinlearning.modules.collect.inter

import com.example.kotlinlearning.database.Student

interface ICollectView {

      fun showResultSuccess(result: List<Student> ?)

      fun showIUD(iudResult: Boolean)
}