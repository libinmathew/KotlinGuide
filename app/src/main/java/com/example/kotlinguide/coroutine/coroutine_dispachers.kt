package com.example.kotlinguide.coroutine

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking{

    dispatchersIOExample()

    dispatchersDefaultExample()

    dispatchersUnconfinedExample()

    dispatchersOnCustomThreadExample()
}


/**Executes coroutines on a background thread optimized for I/O operations (e.g., network requests, file access, database operations).
 *
 *
 Use Case: Used for tasks that involve waiting for external resources.

 *
 *Thread Pool: Uses a shared thread pool optimized for I/O.
*/
suspend fun dispatchersIOExample(){
    val result = withContext(Dispatchers.IO) {
        // Simulate a network request
        delay(1000L)
      return@withContext  "Data from network"
    }
    println("Result: $result")
}

/** Executes coroutines on a background thread optimized for CPU-intensive tasks.
 *
 *
Use Case: Used for tasks that involve heavy computations or processing.
 *
 *Thread Pool: Uses a shared thread pool optimized for CPU-bound operations.*/

suspend fun dispatchersDefaultExample(){
    val result = withContext(Dispatchers.Default) {
        // Simulate a CPU-intensive task
        var sum = 0
        for (i in 1..100000000) {
            sum += i
        }
        sum
    }
    println("Result: $result")
}

/** Executes the coroutine on the current thread until the first suspension point.
 *
 * After suspension, it resumes on the thread that performed the suspension.
 *
 *
 *Use Case: Generally not recommended for most use cases. It can be useful in specific scenarios where you need to avoid context switching.
 *
 *Unpredictable: The thread on which the coroutine resumes can be unpredictable.*/

suspend fun dispatchersUnconfinedExample(){
    val result = withContext(Dispatchers.Unconfined) {
        delay(1000L)
      return@withContext  "Data from Unconfined"
    }
    println("Result: $result")
}


/**Purpose: Creates a new dispatcher that uses a single thread.
 *
Use Case: Useful for tasks that need to be executed on a specific thread.
 *
Resource Intensive: Creating a new thread for each dispatcher can be resource-intensive.
*/

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
suspend fun dispatchersOnCustomThreadExample() {
    val dispatcher = newSingleThreadContext("MyThread")
    withContext(dispatcher) {
        println("Running on ${Thread.currentThread().name}")
    }
    dispatcher.close()
}