/**higher-order function takes another function as an argument or returns another function. Lambda expressions are frequently supplied as arguments to or returned from higher-order functions. Kotlin Higher-Order Function can likewise use an anonymous function for this purpose.*/

fun printMessage(name: String) {
    println("In printMessage() function")
    println("Hi from $name")
}

/**
 *
 * Higher order function with function as argument(argFunction)
 *
 */
fun higherOrderFunction(argFunction: (name: String) -> Unit, name: String) {
    println("In higher order function")
    println("Calling printMessage() function")
    argFunction(name)
}


/**
 *
 * Higher order function with function as return.
 *
 */
fun higherOrderFunction(): (name: String) -> Unit {
    println("In higher order function")
    return { name ->
        println("Inside the lambda function")
        println("Hi from $name")
    }
}


fun main() {
    higherOrderFunction(::printMessage, "Coding Ninjas")


    val functionName = higherOrderFunction()
    functionName("Coding Ninjas")
}

