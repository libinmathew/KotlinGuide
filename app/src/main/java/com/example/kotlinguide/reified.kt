package com.example.kotlinguide

fun <T> printValue(value: T) {
    // println(T::class.java) // Error: Cannot access T::class.java
    println(value?.toString()) // This will print the actual type of the value
}


/**Generic variable type can only access by using reified keyword*/
inline fun <reified T> printType(value: T) {
     println(T::class.java) // Error: Cannot access T::class.java

}

fun main() {
    printValue("Hello") // Output: class java.lang.String
    printValue(123) // Output: class java.lang.Integer


    printType("Hello") // Output: class java.lang.String
    printType(123) // Output: class java.lang.Integer

}