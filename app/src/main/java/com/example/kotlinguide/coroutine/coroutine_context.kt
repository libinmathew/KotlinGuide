package com.example.kotlinguide.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


 /**The CoroutineContext is a set of elements that define the behavior of a coroutine. It’s made of:

 Job — controls the lifecycle of the coroutine.
 *
 CoroutineDispatcher — dispatches work to the appropriate thread.
 *
 CoroutineName — name of the coroutine, useful for debugging.
 *
 CoroutineExceptionHandler — handles uncaught exceptions, will be covered in Part 3 of the series.
 *
 *What’s the CoroutineContext of a new coroutine?  New instance of Job will be created, allowing us to control its lifecycle. The rest of the elements will be inherited from the CoroutineContext of its parent (either another coroutine or the CoroutineScope where it was created).
 **/



fun main(){

    val scope = CoroutineScope(Job() + Dispatchers.Main)
    val job = scope.launch {
        // New coroutine that has CoroutineScope as a parent
        val result = async {
            // New coroutine that has the coroutine started by
            // launch as a parent
        }.await()
    }

}