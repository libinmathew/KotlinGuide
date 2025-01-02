package com.example.kotlinguide


/**There are two types of Constructors in Kotlin.
 *
Primary Constructor :  Constructor is declared with the class header, unlike Java, where you have to declare the Constructor in the class body.
 *
 * Secondary Constructor: The secondary constructor is created using the keyword constructor. It is used to initialize a group of values. In Kotlin, a single class can have more than one secondary constructor.
 *
 * Reference : [constructor-docs](https://www.simplilearn.com/tutorials/kotlin-tutorial/guide-to-kotlin-constructors)
 * */
open class ShapeClass

/**Inheritance between classes is declared by a colon (:). Classes are final by default; to make a class inheritable, mark it as open:*/
class RectangleClass(private val height: Double, private val length: Double): ShapeClass() {
    /**Primary constructor can have a optional init block*/
    init {
        println("Rectangle")
    }
    val perimeter = (height + length) * 2

    /**We can also use primary and secondary constructor in the same class, but for that, we have to authorize the secondary constructor to the primary constructor(secondary constructor need to call primary constructor), which is done with the help of this() keyword.*/
    constructor(color: String) : this(height = 10.0, length = 45.0){
        println("Color $color")
    }

}


fun main() {
    val rectangle = RectangleClass(5.0, 2.0)
    val coloredRectangle = RectangleClass(color = "red")
    println("The perimeter is ${coloredRectangle.perimeter}")
    println("The perimeter is ${rectangle.perimeter}")
}
