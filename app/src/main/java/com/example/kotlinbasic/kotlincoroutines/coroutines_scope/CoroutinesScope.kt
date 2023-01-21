package com.example.kotlinbasic.kotlincoroutines.coroutines_scope

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

@OptIn(DelicateCoroutinesApi::class)

/*vd1
fun main(){
    //Khong the goi lauch & async ngoai 1 coroutinesScope
//    runBlocking {
//        launch {
//
//        }
//
//        async {
//
//        }
//    }
//    CoroutineScope(Dispatchers.Default).launch {
//    }
//    GlobalScope.launch {
//
//    }

    runBlocking {
        val job: Job = launch {
            launch {
                delay(100)
                println("Coroutines 1 : Hello")
                delay(1000)
                println("Coroutines 1 : Goodbye")
            }
            launch {
                delay(100)
                println("Coroutines 2 : Hello")
                delay(1000)
                println("Coroutines 2 : Goodbye")
            }
            //GlobalScope se khong bi huy ke ca khi Coroutine cha bi huy
            GlobalScope.launch {
                delay(100)
                println("Coroutines 3 : Hello")
                delay(2000)
                println("Coroutines 3 : Goodbye")
            }
        }
        delay(500)
        job.cancel()
        delay(2500)
    }
}
 */

fun main(){
    runBlocking {
        val job = launch {
            repeat(3){
                launch {
                    delay(100)
                    println("Coroutine $it")
                }
            }
            println("Print from parent")
        }
        job.join()
        delay(1000)
    }
}
class MyCoroutineScope:CoroutineScope{
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

}