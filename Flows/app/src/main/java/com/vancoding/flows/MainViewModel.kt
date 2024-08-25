package com.vancoding.flows

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val myFlow = flow<Int> {
        for (i in 1..100) {
            emit(i)
            delay(1000L)
        }
    }

    init {
        backPressureDemo()
    }

    private fun backPressureDemo() {
        val myFlow1 = flow<Int>{
            for (i in 1..10) {
                Log.i("MyTag", "Produced $i")
                emit(i)
                delay(1000L)
            }
        }

        viewModelScope.launch {
            myFlow1
                .filter {
                    count -> count%3 == 0
                }
                .map {
                    it -> showMessage(it)
                }
                .collect {
                Log.i("MyTag", "Consumed $it")
            }
        }
    }

    fun showMessage(count: Int) : String {
        return "Hello $count"
    }
}