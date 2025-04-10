package com.example.kotlinguide.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/**launch creates a new coroutine and launches it within the current scope (the runBlocking coroutine's scope).
 *
 *
 * val job ,The launch function returns a Job object, which represents the launched coroutine. This Job object is stored in the job variable
 *
 * job.join(): This suspends the current coroutine (the runBlocking coroutine) until the coroutine represented by the job object completes.
 *
 *
 * A Job is a handle to a coroutine. For every coroutine that you create (by launch or async), it returns a Job instance that uniquely identifies the coroutine and manages its lifecycle.
 *
 * */
fun main() = runBlocking {
    val job = launch { // launch a new coroutine and keep a reference to its Job
        delay(1000L)
        println("World!")
    }
    println("Hello")
    job.join() // we can suspend a coroutine by join()
    println("Done")
}


//https://medium.com/androiddevelopers/coroutines-first-things-first-e6187bf3bb21
/*
fun com.example.kotlinguide.main() = runBlocking {
    val scope = CoroutineScope(Job())

    println("Scope created")

    val job1 = scope.launch {
        println("Coroutine 1 started")
        delay(1000)
        println("Coroutine 1 completed")
    }

    val job2 = scope.launch {
        println("Coroutine 2 started")
        delay(2000)
        println("Coroutine 2 completed")
    }

    joinAll(job1, job2) // Wait for both coroutines to complete

    println("All child coroutines completed")

    // You can still launch new coroutines in the scope, but it's not recommended
    val job3 = scope.launch {
        println("Coroutine 3 started")
        delay(500)
        println("Coroutine 3 completed")
    }

    job3.join()
    println("Coroutine 3 completed")

    scope.cancel()
    println("Scope cancelled")
}*/
