package com.example.kotlinguide.coroutineFlow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

/**Flows can be executed in different coroutine contexts.
  flowOn: Changes the context in which the flow emits values.
 *
 * here flow emit the value in worker thread(IO).Values are collected in main thread.
 */
fun main() = runBlocking{
    flow {
        println("Emitting in thread: ${Thread.currentThread().name}")
        emit(1)
    }.flowOn(Dispatchers.IO)
        .collect { println("Collecting in thread: ${Thread.currentThread().name}") }



}