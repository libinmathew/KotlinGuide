package com.example.kotlinguide.coroutineFlow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**Flows can be executed in different coroutine contexts.
  flowOn: Changes the context in which the flow emits values.
 *
 * here flow emit the value in worker thread(IO).Values are collected in com.example.kotlinguide.main thread.
 */
/*fun main() = runBlocking{
    flow {
        println("Emitting in thread: ${Thread.currentThread().name}")
        emit(1)
    }.flowOn(Dispatchers.IO)
        .collect { println("Collecting in thread: ${Thread.currentThread().name}") }



}*/

/** Even if we emits the flow in IO thread, it will collect according to the context of the collector.**/

fun main(): kotlin.Unit = runBlocking {
    println("runBlocking: ${Thread.currentThread().name}")
    launch {
        flow {
            println("1 Emitting in thread: ${Thread.currentThread().name}") // On IO thread
            emit(1)
        }.flowOn(Dispatchers.IO)
            .collect {
                println("1 Collecting in thread: ${Thread.currentThread().name}") // On main thread
            }
    }
    launch(Dispatchers.IO) {
        flow {
            println("2 Emitting in thread: ${Thread.currentThread().name}") // On IO thread
            emit(1)
        }.flowOn(Dispatchers.IO)
            .collect {
                println("2 Collecting in thread: ${Thread.currentThread().name}") // On IO thread
            }
    }
}


