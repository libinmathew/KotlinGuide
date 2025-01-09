package com.example.kotlinguide.coroutineFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/** Flow (Cold Stream): A Flow is a cold stream. This means that it doesn't start producing values until a collector starts listening. Each collector triggers a new execution of the flow's producer.
 *
 *
 *
 * Flow (Cold Stream): A Flow is a cold stream. This means that it doesn't start producing values until a collector starts listening. Each collector triggers a new execution of the flow's producer.
 *
 * SharedFlow and StateFlow (Hot Streams): SharedFlow and StateFlow are hot streams.
 *
 * They start producing values as soon as they are created, regardless of whether there are any collectors.
 *
 * Multiple collectors can receive values from a hot stream. Cold Flow (Flow)
 *
 * Lazy Execution: A cold flow's producer (the code inside the flow { ... } block) is executed only when a collector starts listening.
 *
 * Independent Execution: Each collector triggers a new, independent execution of the flow's producer.
 *
 * Single Collector: A regular Flow is designed for a single collector. If you try to collect it multiple times concurrently, you'll likely encounter issues.
 *
 * In this example we have  multiple collector it just used for example, it is not recommend. Hot flows are designed for multiple collectors.
 *
 * */
/*
fun main() = runBlocking {
    val coldFlow = flow {
        println("Flow producer started")
        for (i in 1..3) {
            delay(100)
            println("Emitting $i")
            emit(i)
        }
        println("Flow producer finished")
    }

    println("First collector starts")
    coldFlow.collect {
        println("Collector 1 received: $it")

    }
    println("First collector finished")

    delay(200)

    println("Second collector starts")
    coldFlow.collect {
        println("Collector 2 received: $it")
    }
    println("Second collector finished")




}
*/

/*
fun main() = runBlocking {
    val stateFlow = MutableStateFlow(0)

    // Update the state
    stateFlow.value = 1

    // Collect the state
    launch {
        stateFlow.collect {
            println("Collector 1: $it")
        }
    }


    delay(100)
    stateFlow.value = 2 // Update the state again
    delay(100)
    launch {
        stateFlow.collect {
            println("Collector 2: $it")
        }
    }

    stateFlow.value = 3

}
*/


fun main() = runBlocking {
    val sharedFlow = MutableSharedFlow<Int>(replay = 2) // Replay last 1 value

    // Emit values
    launch {
        sharedFlow.emit(1)
        delay(100)
        sharedFlow.emit(2)
    }

    // Collect values
    launch {
        sharedFlow.collect {
            println("Collector 1: $it")
        }
    }

    delay(50)
    launch {
        sharedFlow.collect {
            println("Collector 2: $it")
        }
    }
    delay(200)
    sharedFlow.emit(3)
}

