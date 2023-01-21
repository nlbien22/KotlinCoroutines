package com.example.kotlinbasic.kotlincoroutines.coroutinescontext

import android.util.Log
import com.example.kotlinbasic.MainActivity
import kotlinx.coroutines.*

object TestDispatchers{

    @OptIn(DelicateCoroutinesApi::class)
    fun runMyFirstCoroutines(){
        GlobalScope.launch(Dispatchers.Default) {
            Log.d(MainActivity::class.java.simpleName,
                "Dispatcher Default run on ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.IO) {
            Log.d(MainActivity::class.java.simpleName,
                "Dispatcher IO run on ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Main) {
            Log.d(MainActivity::class.java.simpleName,
                "Dispatcher Main run on ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Unconfined) {
            Log.d(MainActivity::class.java.simpleName,
                "Dispatcher Unconfined run on ${Thread.currentThread().name}")
        }
        GlobalScope.launch(newSingleThreadContext("My Thread")) {
            Log.d(MainActivity::class.java.simpleName,
                "Dispatcher My Thread run on ${Thread.currentThread().name}")
        }
    }
}