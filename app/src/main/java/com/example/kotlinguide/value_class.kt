package com.example.kotlinguide


/**A value class in Kotlin is a special kind of class that is designed to primarily hold a single value.
 *
 * It's a way to create a type-safe wrapper around a primitive type or another value, while potentially avoiding some of the overhead of a full-fledged class.
 *
 * A value class must have exactly one property declared in its primary constructor.
 *
 *  This is the underlying value that the value class is wrapping.
 *
 * val Only This property must be declared as val (immutable).•No var: You cannot have var.
 *
 * Extend: You cannot extend from a value class.•Be extended: You cannot extend a value class.
 *
 * The value is the main element, and you must have one. What's Allowed in value classes (Instead of Backing Fields)
 *
 *
 *we can add properties that are computed (derived from other values). These properties do not have backing fields.
 * **/
@JvmInline
value class Meter(val value: Double) {
    val valueInFeet: Double
        get() = value * 3.281

    fun toFeet(): Double {
        return value * 3.281
    }
}

@JvmInline
value class Password(val value: String) {


    fun isValid(): Boolean {
        return value.length >= 8
    }

}

fun main() {
    val distance = Meter(10.0)
    val secret = Password("mySecretPassword")

    println("Distance in meters: ${distance.value}") // Access the underlying value
    println("Distance in feet: ${distance.toFeet()}") // Use a method
    println("Is password valid: ${secret.isValid()}")

    // val anotherPassword: com.example.kotlinguide.Password = distance //This will not compile, because it is not the correct type.
    val anotherPassword: Password = Password("mySecretPassword2")
}