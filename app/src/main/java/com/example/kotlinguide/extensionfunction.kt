package com.example.kotlinguide
/**Extension functions in Kotlin help us write our own utility functions to enhance the reusability of code. Internally, extension functions are resolved statically at compile time with respect to the class for which they are created, allowing access to the public members of that class (without modifying the source code).*/

fun main() {
    val circle = Circle(5.0)
    val rectangle = Rectangle(4.0, 6.0)

    println("Circle perimeter: ${circle.perimeter()}") // Output: Circle perimeter: 31.41592653589793
    println("Rectangle perimeter: ${rectangle.perimeter()}") // Output: Rectangle perimeter: 20.0
}

interface Shape {
    fun area(): Double
}

fun Shape.perimeter(): Double {
    return when (this) {
        is Circle -> 2 * Math.PI * this.radius
        is Rectangle -> 2 * (this.width + this.height)
        else -> 0.0 // Default case if perimeter calculation is not possible
    }
}

class Circle(val radius: Double) : Shape {
    override fun area(): Double = Math.PI * radius * radius
}

class Rectangle(val width: Double, val height: Double) : Shape {
    override fun area(): Double = width * height
}