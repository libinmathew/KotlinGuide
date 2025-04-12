package com.example.kotlinguide


fun main() {
  //List
    val colors = listOf<String>(
        "RED",
        "BLUE",
        "GREEN",
        "ORANGE",
        "YELLOW",
        "PURPLE",
        "PINK",
        "BLACK",
        "WHITE",
        "GRAY",
        "BROWN",
        "CYAN",
        "MAGENTA",
        "LIME",
        "NAVY",
        "TEAL",
        "MAROON",
        "OLIVE",
        "SILVER",
        "GOLD",
        "SILVER",
        "GOLD",
        "SILVER",
        "GOLD",
        "SILVER",
        "GOLD",
        "SILVER",
        "GOLD"
    );
    println(colors.slice(0..4))

    val arrayList = arrayListOf<String>()// fun returns arrayList
    val mutableList=mutableListOf<String>()// fun returns arraylist.


    val readOnlyColors: List<String> = listOf("Red", "Green", "Blue")
    val mutableNumbers: MutableList<Int> = mutableListOf(1, 2, 3)
    mutableNumbers.add(4) // Add an element
    println(mutableNumbers[0]) // Access by index (0-based)


    //Set

    val readOnlyUniqueNames: Set<String> = setOf("Alice", "Bob", "Charlie")
    val mutableUniqueNumbers: MutableSet<Int> = mutableSetOf(1, 2, 3, 2) // 2 is ignored
    mutableUniqueNumbers.add(4)
    println(mutableUniqueNumbers) // Output (order might vary): [1, 2, 3, 4]

    val hashSet = hashSetOf<String>() //It uses a hash table, which is fast for adding, removing, and checking for the existence of elements.
    val linkedHashSet= linkedSetOf<String>()
    linkedHashSet.add("")

    readOnlyUniqueNames.contains("Alice")


//map
    val readOnlyAges: Map<String, Int> = mapOf("Alice" to 30, "Bob" to 25, "Charlie" to 35)
    val mutableScores: MutableMap<String, Int> = mutableMapOf("Alice" to 90, "Bob" to 85)
    mutableScores["Charlie"] = 95 // Add a key-value pair
    println(mutableScores["Bob"])
    // Access by key



    val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5)
    val names: Array<String> = arrayOf("Alice", "Bob", "Charlie")

    val person: Pair<String, Int> = Pair("Alice", 30)
    println(person.first) // Alice
    println(person.second) // 30

    val coordinates: Triple<Int, Int, Int> = Triple(10, 20, 30)
    println(coordinates.third)


}