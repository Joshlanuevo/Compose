package com.vancoding.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.vancoding.android.ui.theme.AndroidTheme

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity-Test"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Activity is created.")
        enableEdgeToEdge()
        setContent {
            AndroidTheme {
                MainScreen()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Activity is started.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Activity is resumed.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Activity is paused.")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Activity is stopped.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Activity is destroyed.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: Activity is restarted.")
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Button(
            onClick = {
                val intent = Intent(context, SecondActivity::class.java)
                context.startActivity(intent)
            }
        ) {
            Text("Click Me")
        }
    }
}