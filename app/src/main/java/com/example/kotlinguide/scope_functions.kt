package com.example.kotlinguide

/**Scope functions are a set of higher-order functions in the Kotlin standard library that allow you to execute a block of code within the context of an object.
 *
 * They provide a way to make your code more concise and readable by avoiding the need to repeatedly refer to the object by its name.
 *
 * Key Characteristics
 *
Temporary Scope: They create a temporary scope where you can access the object without using its name.
 *
Object Access: The object is accessed either as this or it within the scope, depending on the function.
 *
Return Value: Each scope function returns a value, which can be the object itself or the result of the lambda expression.
 *
The Five Scope Functions Kotlin provides five scope functions: let, run, with, apply, and also. They all perform similar actions but differ in how they make the object available within the scope and what they return.

let: Use when you need to perform operations on a nullable object or transform an object.
 *
run: Use when you need to initialize an object and perform operations on it, or when you need to execute code within the context of an object.
 *
with: Use when you need to perform multiple operations on an object or access multiple properties of an object.
 *
apply: Use when you need to configure an object or set its properties.
 *
also: Use when you need to perform side effects on an object or log/debug an object.
 *
Benefits of Scope Functions
Conciseness: They reduce the need to repeatedly refer to the object by its name.
Readability: They make your code more expressive and easier to understand.
Code Organization: They help to group related operations on an object. In Summary Scope functions are a powerful feature in Kotlin that can make your code more concise, readable, and organized. By understanding the differences between let, run, with, apply, and also, you can choose the right scope function for each situation and write more idiomatic Kotlin code. Let me know if you have any more questions or specific scenarios you'd like to explore!

 **/


fun main() {
    letExample()
    runExample()
    withExample()
    applyExample()
    alsoExample()
}


/**Object Access: The object is accessed as it.
 *
Return Value: Returns the object itself.
 *
Use Cases:
Performing side effects on an object.
 *
Logging or debugging an object.
 *
Chaining operations that don't modify the objec*/
fun alsoExample() {
    data class Email(var to: String, var subject: String, var body: String)

    val email = Email("test@example.com", "Hello", "This is a test email").also {
        println("Sending email to: ${it.to}")
    }
    println("Email: $email") // Output: Email: Email(to=test@example.com, subject=Hello, body=This is a test email)
}


/**
 * Object Access: The object is accessed as this.
 *
 * Return Value: Returns the object itself.
 *
 * Use Cases:Initializing an object and setting its properties.
 *
 * Configuring an object.
 *
 * Chaining operations that modify the object.*/
fun applyExample() {
    data class Book(var title: String = "", var author: String = "", var year: Int = 0)

    val book = Book().apply {
        title = "The Hitchhiker's Guide to the Galaxy"
        author = "Douglas Adams"
        year = 1979
    }
    println("Book: $book") // Output: Book: Book(title=The Hitchhiker's Guide to the Galaxy, author=Douglas Adams, year=1979)
}


/**Object Access: The object is accessed as it.
 *
Return Value: Returns the result of the lambda expression.
 *
Use Cases:
 *Null checks and transformations.
 *
 *Chaining operations on an object.
 *
Executing code only if an object is not null.*/
fun letExample() {
    val name: String? = "Alice"
    val length = name?.let {
        println("Name is not null: $it")
        it.length
    }
    println("Length: $length")


}

/**Object Access: The object is accessed as this.
 *
Return Value: Returns the result of the lambda expression.
 *
Use Cases:
Initializing an object and performing operations on it.
 *
Executing code within the context of an object.
 *
Chaining operations on an object.**/
fun runExample() {
    data class Person(var name: String, var age: Int)

    val person = Person("Bob", 30).run {
        println("Name: $name, Age: $age")
        age += 1
        this
    }
    println("Updated age: ${person.age}")
}

/**Object Access: The object is accessed as this.
 *
Return Value: Returns the result of the lambda expression.
 *
Use Cases:
Performing multiple operations on an object.
Accessing multiple properties of an object*/
fun withExample() {

    data class Address(var street: String, var city: String)

    val address = Address("123 Main St", "Anytown")
    val formattedAddress = with(address) {
        "$street, $city"
    }
    println("Formatted address: $formattedAddress") // Output: Formatted address: 123 Main St, Anytown
}