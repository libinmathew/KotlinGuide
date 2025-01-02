package com.example.kotlinguide

/** Generics are powerful tool in kotlin which allows declare class, interface and functions with type parameters. It enables us write flexible and reusable code by allowing different data types and maintaining type safety.*/
class Machine<T>(val type: T)


fun <T> singletonList(vararg elements: T): List<T> {
    return listOf(*elements) // The asterisk (*) is the spread operator. It's used when you want to pass an array to a function that expects individual arguments. The spread operator "unpacks" the array into individual elements.
}


fun main() {
    val machine1 = Machine(12)
    val machine2 = Machine("optimus")
    println(machine1.type) // 12
    println(machine2.type) // optimus


    val intList = singletonList(5, 10)
    val stringList = singletonList("Alice", "Ann")
    println(intList) // [5]
    println(stringList) // [5]

    // Variance
    val appleProducer = AppleProducer()
    processFruitProducer(appleProducer)

    val fruitConsumer = FruitConsumerImpl()
    processFruitConsumer(fruitConsumer)


    val appleBox = AppleBox()
    appleBox.put(Apple())
    val fruit: Fruit = appleBox.get()

}

/**Variance :It is about how type relationships between generic types are affected by the type relationships of their type arguments.*/
open class Fruit
class Apple : Fruit()
class Orange : Fruit()


/** Covariance (out) - "Producers"
 *
 *
 * It can only produce (give out) fruits. We can represent this with a generic interface.
 * */
interface FruitProducer<out T> {
    fun produce(): T
}

class AppleProducer : FruitProducer<Apple> {
    override fun produce(): Apple = Apple()
}

fun processFruitProducer(producer: FruitProducer<Fruit>) {
    val fruit: Fruit = producer.produce()
    println("Got a fruit: $fruit")
}


/** Contravariance (in) - "Consumers"
 *
 *It can only consume (take in) fruits. We can represent this with a generic interface:*/
interface FruitConsumer<in T> {
    fun consume(item: T)
}

class FruitConsumerImpl : FruitConsumer<Fruit> {
    override fun consume(item: Fruit) {
        println("Consuming fruit: $item")
    }
}

fun processFruitConsumer(consumer: FruitConsumer<Apple>) {
    consumer.consume(Apple())
}


/**Invariance (No Keyword) - "Both Producer and Consumer"
 *
 *Box that can both produce and consume fruits. We can represent this with a generic interface.*/
interface FruitBox<T> {
    fun put(item: T)
    fun get(): T
}

class AppleBox : FruitBox<Apple> {
    override fun put(item: Apple) {
        println("Putting apple: $item")
    }

    override fun get(): Apple = Apple()
}

