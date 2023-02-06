package com.example.kotlintestproject.model

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlin.Array
import kotlin.collections.List

class Person constructor(var name: String, var age: Int) {


}

open class Animal(val name: String)
class Dog(name: String): Animal(name)

fun present(animal: Animal) {
    println("This is ${animal.name}")
}

interface BaseView
interface ProductView: BaseView
class Presenter<out T>

fun varianceFun() {
    var presenter = Presenter<BaseView>()
    var productPresenter = Presenter<ProductView>()
    presenter = productPresenter
}

public class Array<T>{}

class Computer {
    init {
        val numberArray = arrayOf<Number>(1, 2, 3)
        updateArray(numberArray)
    }

    fun updateArray(array: Array<Number>) {
        array[0] = 4
    }
}

interface List<out E>: Collection<E>{}
public interface MutableList<E>: List<E>, MutableCollection<E>{}

fun addElement(mutableList: MutableList<Any>) {
    mutableList.add("Cat")
}

fun variantCollectionFun() {
    val mutableIntList = mutableListOf(1, 2, 3, 4)
    val mutableAnyList = mutableListOf<Any>(1, 'A')
//    addElement(mutableIntList)
//    addElement(mutableAnyList)
}

fun Any?.logError(error: Throwable, message: String = "error") {
    Log.e(this?.javaClass?.simpleName ?: "null", message, error)
}

inline fun Context.isPermissionGranted(permission: String): Boolean =
    ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED

fun View.show() {
    visibility = View.VISIBLE
}

class User(val name: String, val surname: String) {
    val fullName: String
    get() = "$name $surname"
}

class ViewPropertyExtension() {
    val TextView.trimmedText: String
    get() = text.toString().trim()
}

data class Student(
    val name: String,
    val grade: Double,
    val passing: Boolean
)

val students = listOf(
    Student("John", 4.2, true),
    Student("Bill", 3.5, true),
    Student("John", 3.2, false),
    Student("Aron", 4.3, true),
    Student("Jimmy", 3.1, true)
)