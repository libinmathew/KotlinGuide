package com.example.kotlinguide.coroutine

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.IOException

/**
 * CoroutineExceptionHandler:
 *
CoroutineExceptionHandler is an interface that allows you to define a handler for uncaught exceptions in a coroutine.
 *
 *You can install a CoroutineExceptionHandler in a CoroutineScope to handle exceptions that are not caught by try-catch blocks.
 *
CoroutineExceptionHandler is only invoked for exceptions that are not CancellationException and that are not handled by the coroutine itself.
 *
 *
Exception Propagation:

By default, if a child coroutine throws an exception that is not handled, the exception will propagate up to the parent coroutine, causing the parent and all its other children to be canceled.
This behavior is called structured concurrency.*/


fun main(): Unit = runBlocking {
    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Caught an exception: $exception")
    }
    val scope =
        CoroutineScope(coroutineContext + Job() + exceptionHandler)// need to pass job and context
    println("Inside")
    val job1 = scope.launch() {
        throw IllegalStateException("Network request failed")
    }
    val job2 = scope.launch() {
        throw IOException("Network error")
    }

    joinAll(job2,job2)
}

