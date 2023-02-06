package com.example.kotlintestproject

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlintestproject.model.*
import com.example.kotlintestproject.test.SimpleList

class MainActivity : AppCompatActivity() ,OnClickListen {

    private var btn: Button? = null
    private lateinit var clickListener: OnClickListen
    data class User(val name: String, val surname: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        setOnUserClickedListener { (name, surname) -> toast("clicked to $name $surname") }
        val list = listOf(1, 2, 3, 4, 5)
        forEach(list) { print("Non-local returns ：$it") }
        funReference()
        filterFun()
        present(Dog("Pluto"))
        btn?.setUp()
        sortedByFun()
    }

    private fun sortedByFun() {
        val list = listOf(14, 31, 2)
        println("sort")
        print(list.sortedBy { "$it" })
    }

    private fun Button.setUp() {
        setText("Click me!")
        setOnClickListener { showText("Hello") }
    }

    private fun Button.showText(text: String) {
        toast(text)
    }

    private fun setText(text: String) {

    }

    fun genericFun() {
        class Student(val name: String)
        val studentList = SimpleList<Student>()
        studentList.add(Student("Ted"))
        println("generic type parameter ${studentList.get(0).name}")
    }

    private fun filterFun() {
        val fruits = listOf("Banana", "Orange", "Apple", "Blueberry")
        val bFruits = fruits.filter { it.startsWith("B") }
        println("filterFun : $bFruits")
    }


    private fun funReference() {
        val evenPredicate : (Int) -> Boolean = MathHelper::isEven
        val oddPredicate : (Int) -> Boolean = Math.Companion::isOdd
        val numbers = 1..10
        val even = numbers.filter(evenPredicate)
        val odd = numbers.filter(oddPredicate)
        println("numbers is even : $even")
        println("numbers is odd : $odd")
    }

    object MathHelper {
        fun isEven(i: Int) = i % 2 == 0
    }

    class Math {
        companion object{
            fun isOdd(i: Int) = i % 2 == 1
        }
    }

    fun maxBounded(list: List<Int>, upperBound: Int, lowerBound: Int) : Int{
        var currentMax = lowerBound
        forEach (list) { i->
            when {
                i > upperBound -> return upperBound
                i > currentMax -> currentMax = i
            }
        }
        return currentMax
    }

    private inline fun forEach(list: List<Int>, body: (Int) -> Unit) {
        for(i in list) body(i)
    }

    private inline fun printExecutionTime(f: () -> Unit) {
        val startTime = System.currentTimeMillis()
        f()
        val endTime = System.currentTimeMillis()
        println("It took " + (endTime - startTime))
    }

    private fun measureOperation() {
        printExecutionTime {
            longOperation()
        }
    }

    private fun longOperation() {
        println("execute longOperation")
    }

    fun destructuringFun() {
        val map = mapOf(1 to 2, 2 to "A")
        val text = map.map { (key, value) -> "$key: $value" }
        println("Main activity $text")
        val listOfPairs = listOf(1 to 2, 2 to "A")
        val textList = listOfPairs.map { (first, second) -> "$first and $second" }
        println("Main activity $textList")
    }

    private fun setOnUserClickedListener(listener: (User)->Unit) {
        btn?.setOnClickListener{
            val jack = User(name = "小明", surname = "小胖")
            listener(jack)
        }
    }

    fun btnOnClickListener() {
        val handler = Handler()
        var runnable = Runnable {
//            toast("hello, this is my first kotlin program")
        }
        btn?.setOnClickListener {
            for(i in 1..10) {
                handler.postDelayed(runnable, 5000)
            }
        }
    }

    fun modelExample () {
        val car: Car = Car(6.5)
        car.speed = 9.2
        val speed = car.speed

        val fish = Fish(12, true)
        fish.size = 7
        fish.hungry = true
    }

    fun customListener() {
        setOnclick(this)
        clickListener.call()
    }

    private fun initView() {
        btn = findViewById(R.id.kotlin_button)
    }

     fun Context.toast(text:String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun setOnclick(listener: OnClickListen) {
        this.clickListener = listener
    }

    override fun call() {
        toast("hello")
    }
}

interface OnClickListen {
    fun call()
}