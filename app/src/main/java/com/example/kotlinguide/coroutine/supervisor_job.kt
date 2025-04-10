package com.example.kotlinguide.coroutine

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield


fun main() = runBlocking {

    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Caught an exception: $exception")
    }

    val supervisorJob = SupervisorJob()
    val scope = CoroutineScope(coroutineContext + supervisorJob + exceptionHandler)

    val job1 = scope.launch { updateUIPart1() }
    val job2 = scope.launch { updateUIPart2() }
    val job3 = scope.launch { updateUIPart3() }
    joinAll(job1, job2, job3)
}

suspend fun updateUIPart1() {
    delay(100)
    println("UI Part 1 updated")
}

suspend fun updateUIPart2() {
    yield()
    throw RuntimeException("UI Part 2 update failed")
}

 suspend fun updateUIPart3() {
   yield()
    var i=0
    while (i <= 10000) {
        if (i % 1000 == 0) {
            println("Hello 2 $i")
        }
        i++
    }
    println("UI Part 3 updated")
}