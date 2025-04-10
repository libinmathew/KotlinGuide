package com.example.kotlinguide

interface ResultMessage {
    fun resultMessage(): String
}

sealed class Result : ResultMessage {
    // inner class
    data class Success(val data: String) : Result() {
        override fun resultMessage(): String {
            return "Success"
        }
    }

    data class Error(val message: String) : Result() {
        override fun resultMessage(): String {
            return "Error"
        }
    }

    object Loading : Result() {
        override fun resultMessage(): String {
            return "Loading"
        }
    }
}

object Idle : Result() {
    override fun resultMessage(): String {
        return "Loading"
    }
}

fun processData(): Result {
    return Result.Success("Data processed successfully")

}
//
// 'is' used for type check in when for class,data . object.Result.Loading (without is Object Equality Check used for check Object in kotlin.)
fun handleResult(result: Result) {
    when (result) {
         is Result.Success -> println("Success: ${result.data}")
         is Result.Error -> println("Error: ${result.message}")
         Result.Loading -> println("Loading...")
        is Idle -> TODO()
    }
}

fun main() {
    handleResult(processData())
}