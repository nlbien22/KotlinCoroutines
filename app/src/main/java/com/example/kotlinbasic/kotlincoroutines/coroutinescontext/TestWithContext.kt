package com.example.kotlinbasic.kotlincoroutines.coroutinescontext

import android.util.Log
import com.example.kotlinbasic.MainActivity
import kotlinx.coroutines.*

object TestWithContext {

    @OptIn(DelicateCoroutinesApi::class)
    fun testMyFirstWithContext() {
        newSingleThreadContext("Thread 1").use { context1 ->
            Log.d(
                MainActivity::class.java.simpleName,
                "Context 1 run on ${Thread.currentThread().name}"
            )
            newSingleThreadContext("Thread 2").use { context2 ->
                Log.d(
                    MainActivity::class.java.simpleName,
                    "Context 2 run on ${Thread.currentThread().name}"
                )
                runBlocking(context1) {
                    Log.d(
                        MainActivity::class.java.simpleName,
                        "Working on Context 1 - Thread ${Thread.currentThread().name}"
                    )
                    withContext(context2) {
                        Log.d(
                            MainActivity::class.java.simpleName,
                            "Working on Context 2 - Thread ${Thread.currentThread().name}"
                        )
                    }
                    Log.d(
                        MainActivity::class.java.simpleName,
                        "Backing to Context 1 - Thread ${Thread.currentThread().name}"
                    )
                }
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun testMySecondWithContext() {
        GlobalScope.launch(Dispatchers.IO) {
           //run long time task
            Log.d(
                MainActivity::class.java.simpleName,
                "Run Long Time Task - Thread: ${Thread.currentThread().name}"
            )
            delay(3000L)
            withContext(Dispatchers.Main){
                Log.d(
                    MainActivity::class.java.simpleName,
                    "Update UI on Thread: ${Thread.currentThread().name}"
                )
            }
        }

    }
}