package com.example.kotlinbasic.kotlincoroutines.coroutinescontext

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

fun main(){
    runBlocking {
        /*withTimeout(1800){
            repeat(1000){
                println("I'm sleeping $it...")
                delay(500)
            }
        }
         */
        val result = withTimeoutOrNull(1800){
            //repeat(1000){     //task not complete -> result = null
            repeat(2){      //task complete -> result = Done
                println("I'm sleeping $it...")
                delay(500)
            }
            "Done"
        }
        println("Result: $result")
    }
}