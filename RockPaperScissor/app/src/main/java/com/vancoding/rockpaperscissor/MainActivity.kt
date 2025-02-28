package com.vancoding.rockpaperscissor

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
import com.vancoding.rockpaperscissor.ui.theme.RockPaperScissorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RockPaperScissorTheme {
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

    val constantNumber = 69
    var constantName = "Me and Her"

    val circleRation = 3.141592653589793

    demoFunc(
        number = constantNumber,
        name = constantName,
    )

    demoFunc2(
        circle = circleRation,
        diameter = ,
    )
}

private fun demoFunc(number: Int, name: String) {
    println("Where gonna do $number, $name")
}

private fun demoFunc2(circle: Float, diameter: Float) {
    println("Where gonna do $circle, $diameter")
}