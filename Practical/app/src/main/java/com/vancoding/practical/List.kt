package com.vancoding.practical

import android.util.Log

fun List() {
    /**
     *  List: Ordered collection of elements in which we can access elements
     *  by using indices or indexes that define a position for each element
     * **/

    // Immutable: read-only list
    val immutableFruits = listOf("Apple", "Banana", "Orange")

    immutableFruits.forEach {
        Log.d("List-Print1", it)
    }

    for (fruit in immutableFruits) {
        Log.d("List-Print2", fruit)
    }

    // Mutable: mutable list
    val mutableFruits = mutableListOf("Apple", "Banana", "Orange")
    mutableFruits.forEach {
        Log.d("MutableList", it)
    }
    mutableFruits.add("Mango")
    mutableFruits.forEach {
        Log.d("MutableList", it)
    }
}