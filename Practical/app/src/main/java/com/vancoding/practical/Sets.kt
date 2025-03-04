package com.vancoding.practical

/**
 *  Set: Unordered collection of unique elements (No Duplicate Elements)
 * **/

fun main() {

    // Immutable Sets
    val immutableSet = setOf("Apple", "Banana", "Orange")

    for (immutableSet in immutableSet) {
        println(immutableSet)
    }

    // Mutable Sets: supports both read and write operations/functionalities
    val mutableSet = mutableSetOf("Apple", "Banana", "Orange")
    mutableSet.add("Mango")
    for (mutableSet in mutableSet) {
        println(mutableSet)
    }
}