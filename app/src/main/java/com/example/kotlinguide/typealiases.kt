package com.example.kotlinguide
/**Type aliases allow us to create meaningful names for existing types, improving code comprehension*/
typealias EmployeeId = String

val employeeList = mutableListOf<Employee>()


/** we create a type alias EmployeeId for the String type. This enhances readability and clarifies the purpose of the employeeId parameter.*/
fun addEmployee(employeeId: EmployeeId, employeeName: String){
    employeeList.add(Employee(employeeId, employeeName))
}

fun printEmployees(){
    employeeList.forEach {
        println(it)
    }
}

data class Employee(val employeeId: EmployeeId, val employeeName: String)

fun main(){
    addEmployee("SX-2322", "John")
    addEmployee("BX-1232", "Ron")
    printEmployees()
}