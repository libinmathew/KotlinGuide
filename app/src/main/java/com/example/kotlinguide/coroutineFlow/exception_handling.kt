package com.example.kotlinguide.coroutineFlow

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import java.io.IOException

/**Flows provide operators for handling exceptions.
catch: Catches exceptions that occur during flow emission.
 */
fun main() = runBlocking{
    flow {
        emit(1)
        throw IOException("Network error")
    }.catch { e ->
        println("Caught exception: $e")
        emit(-1)
    }.collect { println(it) } // Output: 1, Caught exception: java.io.IOException: Network error, -1
}



