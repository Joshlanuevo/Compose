package com.vancoding.practical

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vancoding.practical.ui.theme.PracticalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

    val robot : Robot = Robot("Ivan")
    robot.walk()
    robot.speak()
}

// Class
class Robot(val name: String) {

    fun walk() {
        println("$name is walking")
    }

    fun speak() {
        println("Hello, I am $name")
    }
}

/**
*  Primary Constructor
*   - The Primary Constructor define and initialize
*     properties for a class
* 
*   Example:
*       MyClass(parameter1: Type, parameter2: Type) {}
* **/

/**
 *  Visibility Modifiers
 *  public - visible everywhere
 *  private - visible only in the same file
 *  open - visible everywhere and can be overridden
 *  protected - visible in the same file and subclasses
 *  internal - visible in the same module
 * **/

/**
 *  Abstract Class
 *      - Abstract classes cannot be instantiated by their own, and are
 *      typically meant to be a subclassed
 *      - Abstract Functions: Don't have an implementation in the abstract class
 *      but must be implemented in subclasses
 * **/

/**
 *  Interfaces
 *      - Interfaces is a blueprint for a set of functions or properties
 *      that a class must implement
 * **/