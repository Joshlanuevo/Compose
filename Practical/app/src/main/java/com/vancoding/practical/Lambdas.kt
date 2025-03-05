package com.vancoding.practical

/**
 *  Lambda Expression
 *      - A Function that is not declared or a function that has no names,
 *      but passed immediately as an expression
 *      - Lambda expressions are often used as arguments to higher-order functions
 *      - Is a short way to create a function
 *
 *  Syntax of Lambda Expression:
 *  val lambda: (parameters) -> return_type = { arguments -> body }
 *
 *      Two ways to execute the Lambda:
 *          - Add parenthesis after the variable name.
 *          - Call invoke() method
 * **/

fun main() {

    // Examples
    val printMessage = { println("Hello World!") }
    printMessage() // Hello World!
    printMessage.invoke() // Hello World!

    // Lambda Expressions: concise way to define anonymous functions.

    // Basic Lambda Expression: { parameters -> body }

    // 1 - With Parameters and Return Type
    val add: (Int, Int) -> Int = { a, b -> a + b }
    val result = add(2, 3)
    println(result)

    // 2 - With Parameters & No Return Type
    val add2: (Int, Int) -> Unit = { a, b -> println(a + b) }
    add2(5,5)

    // 3 - No Parameters But with Return Value
    val add3: () -> String = { "Hello World!" }
    println(add3())

    // 4 - No Parameters & No Return Value
    val add4: () -> Unit = { println("No Parameters and No Return Value") }
    add4()

    // Direct use of Lambda Expression
    println({ a: Int, b: Int -> a + b }(3, 3))
}