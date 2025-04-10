import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield


/**A Job can go through a set of states: New, Active, Completing, Completed, Cancelling and Cancelled. While we don’t have access to the states themselves, we can access properties of a Job: isActive, isCancelled and isCompleted
 *
 *
 * If the coroutine is in an active state, the failure of the coroutine or calling job.cancel() will move the job in the Cancelling state (isActive = false, isCancelled = true). Once all children have completed their work the coroutine will go in the Cancelled state and isCompleted = true.
 *
 *
 * Refer image coroutine_life_cycle.webp
 * **/

/*
fun com.example.kotlinguide.main(args: Array<String>) = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        launch {
            while (i < 7) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("Hello ${i++}")
                    nextPrintTime += 500L
                }
            }
        }
        delay(500L)
        println("Throwing Exception")
        throw IllegalStateException()

    }

    delay(1000L)
    println("Cancel!")
    // job.cancel()
    println("Done!")
}
*/



/** By default  if any exception or cancellation happen in the parent coroutine, wait for the child to finish, if immediately wants stop the child we need to check isActive or call ensureActive() */
fun main(args: Array<String>) = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        launch {
            while (i <= 7 && isActive ) { //isActive or ensureActive()
               // ensureActive()
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("Hello 1 ${i++}")
                    nextPrintTime += 500L
                }
            }
        }
        launch {
            while (i <= 7) {
                dd()
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("Hello 2 ${i++}")
                    nextPrintTime += 500L
                }
            }

        }
         delay(500L)
        println("Throwing Exception")
        throw IllegalStateException()

    }

    delay(500L)
    println("Cancel!")
  //  job.cancel()
    println("Done!")
}


/** yield also check the whether coroutine completed or cancelled*/
suspend fun  dd (){
  //  yield()
}

/**Above code is rewritten such that isActive checking removed. Delay function add. Now it works as expected child coroutine cancels its child immediately when exception occurs or on cancel()  call. */

/*
fun com.example.kotlinguide.main(args: Array<String>) = runBlocking {

    val job = launch(Dispatchers.Default) {
        var i = 0
        launch {
            repeat(7){
                println("Hello 1 $it")
                    delay(500)

            }
        }
        launch {
            repeat(7){
                println("Hello 2 $it")
                delay(500)

            }

        }
        delay(500L)
        println("Throwing Exception")
        throw Exception("Exception")

    }

    delay(500L)
    println("Cancel!")
    //  job.cancel()
    println("Done!")
}*/
