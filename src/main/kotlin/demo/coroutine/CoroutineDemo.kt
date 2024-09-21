package demo.coroutine

import kotlinx.coroutines.*


/*
fun main() {
    GlobalScope.launch {
        //delay是一个特殊的挂起函数，不会造成线程阻塞，只会挂起协程，并且只能在协程中使用
        delay(1000L)
        println("Hello")
    }

    println("Hi")
//    Thread.sleep(2000L)
    runBlocking {
        delay(2000L)
    }
}*/

/*fun main() = runBlocking {
    GlobalScope.launch {
        //delay是一个特殊的挂起函数，不会造成线程阻塞，只会挂起协程，并且只能在协程中使用
        delay(1000L)
        println("Hello")
    }
    println("Hi")
    delay(2000L)
}*/

/*fun main() = runBlocking {
    val job = GlobalScope.launch {
        //delay是一个特殊的挂起函数，不会造成线程阻塞，只会挂起协程，并且只能在协程中使用
        delay(1000L)
        println("Hello")
    }
    println("Hi")
    //等待子协程执行完毕
    job.join()
}*/

//fun main() = runBlocking { // this: CoroutineScope
//    println(this)
//    launch { // 在 runBlocking 作用域中启动一个新协程
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello,")
//}


//fun main() = runBlocking { // this: CoroutineScope
//    launch {
//        delay(200L)
//        println("Task from runBlocking")
//    }
//
//    coroutineScope { // 创建一个协程作用域
//        launch {
//            delay(500L)
//            println("Task from nested launch")
//        }
//
//        delay(100L)
//        println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
//    }
//
//    println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
//}


@OptIn(DelicateCoroutinesApi::class)
fun main() {
    println("Before launch!")
    GlobalScope.launch {
        println(this::class)
        println("Coroutine started!")
        delay(1000L)
        println("Hello, world!")
    }

    runBlocking {
        println("First:${Thread.currentThread().name}")
        delay(1000L)
        println("Hello First!")
    }

    runBlocking {
        println("Second:${Thread.currentThread().name}")
        delay(1000L)
        println("Hello Second!")
        async() {

        }
    }

    runBlocking {
        println("Third:${Thread.currentThread().name}")
        delay(1000L)
        println("Hello Third!")
    }

    println("After launch!")
    Thread.sleep(2000L)
    println("Process finished!")
}

