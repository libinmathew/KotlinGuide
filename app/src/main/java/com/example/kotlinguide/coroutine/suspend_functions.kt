package com.example.kotlinguide.coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/**The suspend keyword marks a function as a suspension point.
 *
 *
 *
 * A suspend function can only be called from another suspend function or from within a coroutine.
 *
 * When a suspend function is called, the coroutine can be suspended, allowing other coroutines to run.
 *
 *
 * When the suspend function completes, the coroutine resumes execution from where it left off.*/

fun main() = runBlocking {
    doWorld()
    println("Done")
}

// Concurrently executes both sections
suspend fun doWorld() = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}