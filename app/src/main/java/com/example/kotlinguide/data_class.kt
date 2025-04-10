package com.example.kotlinguide


/**
 * A data class in Kotlin is a class that the compiler treats specially to reduce the boilerplate

 * Date  classes whose com.example.kotlinguide.main purpose is to hold data.
 *
 *The Kotlin compiler automatically generates several useful methods for you.(equals(),toString(),componentN()).
 *
 * Data classes must have a primary constructor with at least one parameter.
 *
 * You can also have secondary constructors, but they are not required.
 *
 * All the properties defined in the primary constructor are public val.•
 *
 * You can also add properties that are not defined in the primary constructor.
 *
 * data classes often hold immutable data (using val properties) but they can also use var properties.
 * However, for good practices, using immutable property is preferred.
 *
 * The copy function is very helpful for immutable properties.
 *
 * data class also have member functions.
 *
 * == if properties of object  are same it returns true
 *
 * •Direct inheritance from a data class is not possible in Kotlin.
 * You cannot declare a data class that directly inherits from another data class.
 * The Kotlin language designers intentionally restricted this.
 *
 * •You can extend a class: You can extend from a class, but not from a data class.
 *
 * •You cannot be extended: You cannot extend a data class. Why Not Direct Inheritance?
 * **/


data class User(override val name: String, val age: Int, var city: String) : Parent(name = "") {

}

open class Parent(open val name: String)

fun main() {
    val user1 = User("Alice", 30, "London")
    val user2 = User("Alice", 30, "London")
    val user3 = User("Bob", 25, "Paris")

    println("user1 == user2: ${user1 == user2}") // Output: true (because name and age are equal)
    println("user1 == user3: ${user1 == user3}") // Output: false

    println("user1: $user1")
}