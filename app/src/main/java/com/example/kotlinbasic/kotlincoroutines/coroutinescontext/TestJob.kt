package com.example.kotlinbasic.kotlincoroutines.coroutinescontext

import kotlinx.coroutines.*

/*
@OptIn(DelicateCoroutinesApi::class)
fun main() {
    val job: Job = GlobalScope.launch {
        delay(2000)
        println("hello kotlin")
    }
    val job2: Job = GlobalScope.launch {
        job.join()
        delay(1000)
        println("Im Coroutines")
    }

    //Cho UI Thread ngủ
    Thread.sleep(4000)
}
*/

/*
//Close Coroutines
//Luu y:
fun main(){
    runBlocking {
        val job: Job = launch(Dispatchers.Default) {
            repeat(1000){
                delay(500)
                println("I'm sleeping $it...")
            }
        }
        delay(1500);
        job.cancel()
        println("Cancel Coroutines")
    }
}
*/

/*
//cancel join
@OptIn(DelicateCoroutinesApi::class)
suspend fun main(){
    val time = System.currentTimeMillis()
    val job: Job = GlobalScope.launch(Dispatchers.Default) {
        var start = time
        var i = 0
        //while(i < 5) {      //false: wastes CPU
        while (isActive){   //true
            if(System.currentTimeMillis() >= start) {
                println("I'm sleeping in ${i++}...")
                start += 500L
            }
        }
    }
    delay(1300)
    println("Main: I'm tired of waiting")
    job.cancelAndJoin()     //cancel the job & wait for it completion
    println("Main: Now I can quit")
}
*/

fun main(){
    runBlocking {
        val job: Job = launch {
            try {
                repeat(1000){
                    delay(100)
                    println("Hello coroutines")
                }
            }finally {
                println("Print from finally")
                withContext(NonCancellable){
                    repeat(10){
                        delay(100)
                        println("Print from non cancellable")
                    }

                }
            }
        }

        delay(2000)
        println("i want stop coroutines")
        job.cancel()
    }
}