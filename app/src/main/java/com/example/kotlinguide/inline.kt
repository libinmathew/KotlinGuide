fun main() {
    val student = Student(name = "Alice", age = Age(30))
    println(student.age.value)
    println(student.age.getAgeCategory())


    repeat(5) { index ->
        println("Number: $index")
    }

}



/**
 * Inline Class
 *
 * JvmInline keyword annotates that the class is an inline class.
 *
 *
 *Inline classes are a special type of class in Kotlin that are designed to wrap a single value without the performance overhead of a regular class.
 *
 *The compiler optimizes inline classes by replacing them with their underlying value at compile time, eliminating the need for object allocation.
 *
 *
 *Benefits of Inline Classes
 *
 *Performance: Inline classes avoid the overhead of object allocation, improving performance compared to regular classes.
 *
 *Type Safety: They provide type safety by wrapping a primitive value with a specific type, preventing accidental misuse.
 *
 *

 *Code Readability: They enhance code readability by introducing domain-specific types, making the code more expressive.

 *
 *  Limitations of Inline Classes:
 *
Single Property: Inline classes can only have a single property.

No Identity: They do not have their own identity, meaning they are treated as their underlying value for equality checks.
 *
Inheritance: They cannot inherit from other classes or be inherited from.
 *
 *
 *
 */




@JvmInline
value class Age(val value: Int) {
    enum class AgeCategory {
        CHILD,
        TEENAGE,
        YOUNG_ADULT,
        ADULT,
        SENIOR
    }

    init {
        require(value >= 0) { "Age cannot be negative" }
    }

    fun getAgeCategory(): AgeCategory {
        return when {
            value < 13 -> AgeCategory.CHILD
            value in 13..19 -> AgeCategory.TEENAGE
            value in 20..29 -> AgeCategory.YOUNG_ADULT
            value in 30..59 -> AgeCategory.ADULT
            else -> AgeCategory.SENIOR
        }
    }
}

data class Student(val name: String, val age: Age)


/**Inline functions are a powerful feature that can help you optimize your code by reducing the overhead associated with higher-order functions.
 *
 *
 * The call to repeat is replaced with the actual loop, eliminating the overhead of the function call.
 *
 *
 * When to Use Inline Functions?
 *
 *
 * Higher-Order Functions: You have functions that take lambda expressions as arguments.
 *
 * Performance-Critical Code: You are working with performance-sensitive code where the overhead of function calls can be significant.
 * Small Function Bodies: The function body is relatively small. Inlining large functions can increase code size.
 *
 * Important Considerations
 *
 * Code Size: Inlining can increase code size, especially if the function is called from many places.
 * Noinline Modifier: You can use the noinline modifier on a parameter of an inline function to prevent that specific lambda from being inlined.
 * Crossinline Modifier: You can use the crossinline modifier on a parameter of an inline function to prevent non-local returns from the lambda.
 *
 * Debugging: Inlined code can be slightly harder to debug because the function call is replaced with the actual code.
 *
 * */

inline fun repeat(times: Int, action: (Int) -> Unit) {
    for (i in 0 until times) {
        action(i)
    }
}


