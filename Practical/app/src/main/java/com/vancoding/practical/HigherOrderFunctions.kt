package com.vancoding.practical


/**
 *  Higher-Order Functions
 *      - Accept one or more functions as parameters
 *      - Can return a function as its result
 * **/

fun main() {

    val addResult = operateOnNumers(5, 3){x, y -> x + y}
    val multiplyResult = operateOnNumers(5, 3){x, y -> x * y}
    println(addResult)
    println(multiplyResult)
}


fun operateOnNumers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}