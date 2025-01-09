package com.example.kotlinguide.coroutineFlow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking


/**
 * Coroutines: Coroutines are a way to write concurrent code in a sequential manner. They are lightweight threads that can be suspended and resumed, allowing you to perform asynchronous operations without blocking the main thread.
 *
 * Flows: Flows are a type that can emit multiple values sequentially, asynchronously. They are designed to handle streams of data over time, such as database updates, network responses, or UI events. How Flows Use Coroutines*/
fun main() = runBlocking {
    flow {
        println("Emitting in thread: ${Thread.currentThread().name}")
        for (i in 1..3) {
            delay(100)
            emit(i)
        }
    }.flowOn(Dispatchers.IO)
        .collect {
            println("Collecting $it in thread: ${Thread.currentThread().name}")
        }

    flowMap()
    flowFilter()
    flowTransform()
    flowCombine()
    flowFlatMapConcat()
    flatMapMerge()
    flatMapLatest()
}


/**map:Transforms each element emitted by the flow.*/
suspend fun flowMap() {
    flowOf(1, 2, 3)
        .map { it * 2 }
        .collect { println(it) }
}


/**filter:Filters elements based on a predicate*/
suspend fun flowFilter() {
    flowOf(1, 2, 3)
        .map { it * 2 }
        .collect { println(it) }
}

/**transform: A more general-purpose transformation that allows you to emit multiple values for each input value or skip values entirely*/
suspend fun flowTransform() {
    println("Transform")
    flowOf(1, 2, 3)
        .transform {
            emit(it * 2)
            if (it > 1) emit(it * 3)
        }
        .collect { println("$it") }
}

/**Combines two flows by taking the latest emitted values from each flow and applying a transformation.*/
suspend fun flowCombine() {
    println("Combine")
    val flow1 = flow {
        emit("A")
        delay(100)
        emit("B")
    }
    val flow2 = flow {
        emit(1)
        delay(200)
        emit(2)
    }
    flow1.combine(flow2) { a, b -> "$a$b" }
        .collect { println(it) }
}

/**flatMapConcat: Flattens a flow of flows by concatenating the inner flows sequentially.*/
@OptIn(ExperimentalCoroutinesApi::class)
suspend fun flowFlatMapConcat() {
    println("flatMapConcat")
    flowOf(1, 2, 3)
        .flatMapConcat {
            flow {
                emit(it)
                delay(100)
                emit(it * 2)
            }
        }
        .collect { println("$it") }
}

/**flatMapMerge: Flattens a flow of flows by merging the inner flows concurrently*/
@OptIn(ExperimentalCoroutinesApi::class)
suspend fun flatMapMerge() {
    println("flatMerge")
    flowOf(1, 2, 3)
        .flatMapMerge {
            flow {
                emit(it)
                delay(100)
                emit(it * 2)
            }
        }
        .collect { println(it) }
}

/**flatMapLatest: Flattens a flow of flows by canceling the previous inner flow when a new one is emitted.*/
@OptIn(ExperimentalCoroutinesApi::class)
suspend fun flatMapLatest() {
    println("flatMerge")
    flowOf(1, 2, 3)
        .flatMapLatest { flow { emit(it); delay(100); emit(it * 2) } }
        .collect { println(it) }
        // Output: 1, 2, 2, 4, 3, 6 (only the latest flow is fully collected)
}


