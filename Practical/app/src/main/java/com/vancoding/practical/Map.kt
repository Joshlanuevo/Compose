package com.vancoding.practical

fun main() {
    /**
     *  Map:
     *      - Unordered collection of key-value pairs
     *      - Is an object that maps keys to values
     *      - Map keys are unique
     *      - Map values can be duplicate
     * **/

    // Immutable Maps: read-only map
    val immutableMap = mapOf("Apple" to 6, "Banana" to 3, "Orange" to 9)
    for (key in immutableMap.keys) {
        println(key)
    }
    for (value in immutableMap.values) {
        println(value)
    }
}