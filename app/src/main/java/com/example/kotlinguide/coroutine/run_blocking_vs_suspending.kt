package com.example.kotlinguide.coroutine

import androidx.compose.foundation.checkScrollableContainerConstraints
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * runBlocking is a coroutine builder that starts a new coroutine and blocks the current thread until that coroutine and all its children complete:
 */
/*//Suspending
@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
fun com.example.kotlinguide.main() = runBlocking {
    println("Start of runBlocking")

    val dispatcher = newSingleThreadContext("MyThread")

    launch(dispatcher) {
        // dispatcher thread is free after call delayMock()
        delayMock()
        println("Child coroutine 1 finished")
    }

    launch(dispatcher) {
        delayMock()
        println("Child coroutine 2 finished")
    }

    println("After launching child coroutines")
}*/
/*Start of runBlocking
After launching child coroutines
Child coroutine 2 finished
Child coroutine 1 finished*/


suspend fun delayMock() {
    // with context switches the threads to IO
    withContext(Dispatchers.IO) {
        // temporality cease execution for 2sec
        Thread.sleep(2000)

    }
}

//runBlocking
@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
fun main() = runBlocking {
    println("Start of runBlocking")

    val dispatcher = newSingleThreadContext("MyThread")

    launch(dispatcher) {
        // dispatcher thread is free after call delayMock()
        runBlocking {
            delayMock()
            println("Child coroutine 1 finished")
        }

    }

    launch(dispatcher) {

        runBlocking {
            delayMock()
            println("Child coroutine 2 finished")
        }

    }

    println("After launching child coroutines")
}


/*output
Start of runBlocking
After launching child coroutines
Child coroutine 1 finished
Child coroutine 2 finished

Process finished with exit code 0*/
