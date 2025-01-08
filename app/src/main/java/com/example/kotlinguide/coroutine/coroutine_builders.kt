 import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


fun main() = runBlocking {
    println("Start on ${Thread.currentThread().name}")
      launchExample()
      withContextExample()
      val s = asyncExample()
}


/** Launch is a coroutine builder, meaning it's a function that creates and starts a new coroutine.
 *
 *
 *Fire-and-Forget: It's typically used for tasks that don't return a value and don't need to be waited on.
 *
 *Returns a Job: launch returns a Job object, which represents the launched coroutine. You can use this Job object to manage the coroutine's lifecycle (e.g., cancel it, wait for it to complete).
 *
 *
 *Coroutine Scope: launch is an extension function on CoroutineScope, meaning it must be called within a CoroutineScope. This ensures that the coroutine is properly managed and cancelled when the scope is cancelled.
 *
 *Concurrency: Coroutines launched with launch run concurrently with other coroutines within the same scope.
 *
 *Non-Blocking: launch itself is non-blocking. It starts the coroutine and returns immediately.
 *

 *Exception Handling: Exceptions thrown within a launch coroutine are typically handled by the CoroutineExceptionHandler in the coroutine's context. If no handler is present, the exception will be propagated to the parent coroutine or the global exception handler. Basic Syntax*/

suspend fun launchExample() = coroutineScope { // this: CoroutineScope
    launch {
        simulateLongRunningTask("launch 1")

    }
    launch {
        simulateLongRunningTask("launch 2")
    }
    println("done")
}



/**
 * WithContext is a suspending function that allows you to switch the CoroutineContext (specifically the CoroutineDispatcher) of the current coroutine for a specific block of code.
 *
 * Use Case: Use withContext when you need to execute a specific block of code on a different thread or dispatcher (e.g., switching to Dispatchers.IO for network or disk operations).
 *
 * Concurrency: withContext does not enable concurrent execution. It suspends the current coroutine, switches to the specified dispatcher, executes the code block, and then resumes the coroutine on the original dispatcher.
 *
 * Return Value: Returns the result of the code block.
 *
 * Suspension: The calling coroutine is suspended when withContext is called.
 *
 * Context Switching: withContext is primarily used for context switching, not for launching new coroutines.*/
suspend fun withContextExample() {
    val result1 = withContext(Dispatchers.Default) {
        simulateLongRunningTask("withContext 1")
        return@withContext "Result 1 from Default"
    }
    val result2 = withContext(Dispatchers.IO) {
        simulateLongRunningTask("withContext 2")
        return@withContext "Result 2 from IO"
    }
    println("Result: $result1 & $result2 on ${Thread.currentThread().name}")
}




/**   Async is a coroutine builder that launches a new coroutine and returns a Deferred<T> object.
 *
 * This Deferred object represents a future result of type T.
 *
 *
 *
 * Use Case: Use async when you need to perform a task concurrently and obtain a result from it later. It's ideal for parallel execution of independent tasks.
 *
 *
 * Concurrency: async enables concurrent execution. The coroutine launched by async runs independently and potentially in parallel with other coroutines.

 *Return Value: Returns a Deferred<T>, which is a promise of a value of type T that will be available in the future.
 *
 *Suspension: The calling coroutine is not suspended when async is called. It continues to execute until it needs the result of the async operation.
 *
 *
 *Retrieving Result: To get the result of the async operation, you need to call .await() on the Deferred object. This suspends the calling coroutine until the result is available.*/


suspend fun asyncExample(): String {
    val deferred1 = CoroutineScope(Dispatchers.IO).async {
        simulateLongRunningTask("Async 1")
        "Data from source 1"
    }
    val deferred2 = CoroutineScope(Dispatchers.IO).async {
        simulateLongRunningTask("Async 2")
        "Data from source 2"
    }
    val result1 = deferred1.await()
    val result2 = deferred2.await()
    return "$result1, $result2"
}


suspend fun simulateLongRunningTask(worker: String) {
    for (i in 1..5) {
        println("$worker Iteration: $i")
        delay(1000L) // Delay for 1 second
    }
}