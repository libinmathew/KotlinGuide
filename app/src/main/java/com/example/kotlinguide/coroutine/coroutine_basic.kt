package com.example.kotlinguide.coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

 /**Coroutine is a concurrency design pattern that you can use to simplify code that executes asynchronously.
  *
  * Coroutines follow a principle of structured concurrency which means that new coroutines can only be launched in a specific CoroutineScope,which delimits the lifetime of the coroutine.
  *
  * On Android, coroutines help to manage long-running tasks that might otherwise block the main thread and cause your app to become unresponsive.

  *
  *
  * runBlocking establishes the corresponding a scope  scope and waits until World! is printed after a second's delay and only then exits.*/
fun main() = runBlocking {

    launch { // launch a new coroutine and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    println("Hello")
}

