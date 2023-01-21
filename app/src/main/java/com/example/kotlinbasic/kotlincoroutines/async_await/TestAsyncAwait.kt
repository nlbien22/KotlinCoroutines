package com.example.kotlinbasic.kotlincoroutines.async_await

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class)
fun main() {
    runBlocking {

        /*val time = measureTimeMillis {
            val a = launch { doSomeThing1() }
            val b = launch { doSomeThing2() }
            println(a + b)
        }
         */

        val time = measureTimeMillis {
            val a: Deferred<Int> = async { doSomeThing1() }
            val b: Deferred<Int> = async { doSomeThing2() }
            println(a.await() + b.await())
        }
        println("Time = $time")
    }

}

suspend fun doSomeThing1(): Int {
    delay(1000)
    return 10
}

suspend fun doSomeThing2(): Int {
    delay(1000)
    return 20
}