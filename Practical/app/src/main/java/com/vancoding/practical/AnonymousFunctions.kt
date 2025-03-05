package com.vancoding.practical


/**
 *  Anonymous Functions
 *      - Is a function without a name.
 *      - It is often use for creating a small one or functions that are passed as arguments
 *      - Are similar to Lambda Expressions, but they allow you to specify the return type
 *
 *  Syntax of Anonymous Functions:
 *  val anonymousFunction: (parameters) -> return_type = fun(arguments): return_type { body }
 *
 * **/

fun main() {

    val numbers = listOf(1, 2, 3, 4, 5)

    // Anonymous Function that squares a number
    val square = fun(x: Int): Int {
        return x * x
    }

    val squaredNumbers = numbers.map(square)
    println(squaredNumbers)

    // Types of Anonymous Functions

    // With Parameters and Return Value
    val multiply = fun(a: Int, b: Int): Int {
        return a * b
    }
    println(multiply(6, 6))

    // With Parameters & No Return Value
    val multiply2 = fun(a: Int, b: Int) {
        println("" + a * b)
    }
    multiply2(7, 7)

    // No Parameters But with Return Value
    val multiply3 = fun(): Int {
        return 8 * 8
    }
    println(multiply3())

    // No Parameters & No Return Value
    val multiply4 = fun() {
        println("No Parameters and No Return Value")
    }
    multiply4()
}