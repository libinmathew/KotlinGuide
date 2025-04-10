package com.example.kotlinguide.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**  coroutineScope creates a new coroutine scope.
It suspends the current coroutine (the runBlocking coroutine) until all coroutines launched within the coroutineScope complete.
 *
 *A CoroutineScope keeps track of any coroutine you create using launch or async (these are extension functions on CoroutineScope).
 *
 * The ongoing work (running coroutines) can be canceled by calling scope.cancel() at any point in time.
 *
 * Reference : [scope-docs](https://medium.com/androiddevelopers/coroutines-first-things-first-e6187bf3bb21)
 */

/*fun com.example.kotlinguide.main() = runBlocking {
    coroutineScope { // this: CoroutineScope
        launch {
            delay(2000L)
            println("World 2")
        }
        launch {
            delay(1000L)
            println("World 1")
        }
        println("Hello")
        delay(1000)

        cancel()
    }

    println("Done")

}*/

fun main() = runBlocking {
    val job= Job()
    val scope = CoroutineScope( job + Dispatchers.Default)

    scope.launch {
        delay(2000L)
        println("World 2")
    }
    scope.launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
    delay(1000)
    scope.cancel()
    //job.cancel()
    println("Done")
}

