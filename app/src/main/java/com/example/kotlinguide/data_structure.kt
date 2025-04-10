package com.example.kotlinguide

import java.util.LinkedList

fun main() {

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

    val arrayList = arrayListOf<String>()
    val linked = LinkedList<String>()

    linked.add("RED")
    linked.add("BLUE")
    linked.add("GREEN")
    linked.add("ORANGE")
    linked.add("YELLOW")


}