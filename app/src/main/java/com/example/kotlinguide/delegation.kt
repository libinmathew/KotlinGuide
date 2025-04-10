/**Delegation in Kotlin is a design pattern that allows an object to delegate some of its responsibilities to another object.
 *

 *Kotlin provides built-in support for delegation by using the by keyword.
 *
 *There are two com.example.kotlinguide.main types of delegation in Kotlin: class delegation and property delegation.*/

fun main() {
    println("Hai")
    println(name) // name initialized
    val summerHolyDayPlans = HolidayPlans(Summer())
    val winterHolyDayPlans = HolidayPlans(Winter())
    println(summerHolyDayPlans.currentWeather())
    println(winterHolyDayPlans.currentWeather())
}

/**The lazy delegate initialises a property only when it is first accessed. This is useful for expensive object initialisation or properties that are only needed during program execution. It optimises resource usage and can improve application performance. By default, lazy initialisation is thread-safe.*/
val name: String by lazy {
    println("Computed")
    "My name"
}


/**Class Delegation
 *
 *Class delegation enables a class to delegate its method implementations to another class. This is beneficial for composition, allowing one class to incorporate the behaviour of another without inheritance. It helps avoid code duplication by delegating interface implementation or functionality to another class.*/


interface Weather {
    fun currentWeather()
}

class Summer : Weather {
    override fun currentWeather() {
        println("Current weather is ${javaClass.simpleName}")
    }
}

class Winter : Weather {
    override fun currentWeather() {
        println("Current weather is ${javaClass.simpleName}")
    }
}

class HolidayPlans(weather: Weather) : Weather by weather {

}