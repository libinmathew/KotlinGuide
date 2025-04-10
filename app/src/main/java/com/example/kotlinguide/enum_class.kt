package com.example.kotlinguide

/**Enums (enumerations) in Kotlin are a special kind of class that represents a fixed set of constants.
 *
 * Enums are useful when you need to define a type that can have a limited set of possible values.
 *
 * Kotlin’s enum classes can contain properties, methods, and implement interfaces.
 *
 * Each enum constant can have its own properties and methods.•This allows you to add data and behavior associated with each constant.
 *
 * Properties and methods cannot be accessed, compiler cannot guarantee that every Color will have this method.
 *
 * So, we cannot call it directly on a variable of type Color (like myColor.isEmergencyColor())
 * **/

interface ColorFeatures{
    fun getName(): String
    fun getHexValue(): String
}

enum class Color(var hex: String): ColorFeatures {
    RED("#FF0000") {
        fun isEmergencyColor(): Boolean {
            return true
        }
        override fun getName(): String {
            return "RED"
        }

        override fun getHexValue(): String {
            return  hex
        }
    },
    GREEN("#00FF00") {
        override fun getName(): String {
            return "GREEN"
        }

        override fun getHexValue(): String {
            return  hex
        }
    },
    BLUE("#0000FF") {
        override fun getName(): String {
            return "BLUE"
        }

        override fun getHexValue(): String {
            return  hex
        }
    };

    fun printHex(){
        println("Hex value: $hex")
    }
}

fun main() {
    val myColor = Color.RED
   // myColor.isEmergencyColor() // This will NOT compile!
    println(myColor) // Output: RED
    println(myColor.hex) // Output: #FF0000
    myColor.printHex() // Output: Hex value: #FF0000

    // Enum entries:
    println("All colors:")
    for (color in Color.entries) { //Color.entries use case: we can creating drop dowm.
        println("- $color")
        println("- ${color.getHexValue()}")

    }
    // When
    val action = when (myColor) {
        Color.RED -> "Stop"
        Color.GREEN -> "Go"
        Color.BLUE -> "Think"
    }
    println("action: $action")
}