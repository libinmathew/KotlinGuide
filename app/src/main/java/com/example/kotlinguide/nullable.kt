package com.example.kotlinguide

/**A nullable type in Kotlin is a type that can hold null values.
 *A nullable variable can be defined by appending a question mark to the type.
 *
 *For example, a nullable string in Kotlin is declared as String?.
 *
 * This means that the variable can either hold a non null value or a null value.
 *
 *Reference [nullable-docs](https://https://www.dhiwise.com/post/kotlin-nullable-parameters-a-simple-guide-for-beginners))
 * */

fun main() {

    var nullableString: String? = "Hello"
    nullableString = null // This is valid since nullableString can hold null values

    greet()
    greet("John")


    printUserInfo(null, null)  // Output: Name: Unknown, Age: 0
    printUserInfo("Alice", null)  // Output: Name: Alice, Age: 0
    printUserInfo(null, 25)  // Output: Name: Unknown, Age: 25
    printUserInfo("Bob", 30)  // Output: Name: Bob, Age: 30


    println(lengthOrNull("Alice"))
    println(length(name = null))
}

/** Default value for nullable variable name.*/
fun greet(name: String? = "Guest") {
    println("Hello, $name!")
}

/**The name variable is a nullable string. By using the safe call operator, you can safely access the length property.
 *
 * If name is null, length is also null, preventing any null reference exception.*/
fun lengthOrNull(name: String?): Int? {
    return name?.length
}

/**The !! operator asserts that name is not null. If name were null, this code would throw a null reference exception.*/
fun length(name: String?): Int {
    return try {
        name!!.length
    } catch (e: NullPointerException) {
        0
    }
}

/**Both name and age are nullable parameters. The elvis operator (?:) is used to provide default values if the parameters are null, ensuring that the function handles null values safely.*/
fun printUserInfo(name: String?, age: Int?) {
    val userName = name ?: "Unknown"
    val userAge = age ?: 0
    println("Name: $userName, Age: $userAge")
}