package com.example.kotlinbasic.kotlincoroutines.firstcoroutines

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
/* First
fun main(){
    GlobalScope.launch {
        delay(1000L)
        println("Hello")
    }
    println("World")
    Thread.sleep(2000L)
}
*/
/*
Second
fun main(){
    runBlocking {
        delay(1000L)
        println("Hello")
        delay(1000L)
        println("Coroutines")
    }
}
 */

fun main(){
    val start = System.currentTimeMillis();
    runBlocking {
        repeat(1_000_000){
            launch {
              println("Hello")
            }
        }
    }
    val end = System.currentTimeMillis()
    println("Time = ${end - start} ms" )
}