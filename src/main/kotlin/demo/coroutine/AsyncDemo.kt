package com.demo.coroutine

import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2024/9/20
 */

fun main() = runBlocking {

    val job = launch {
        println("In launch: ${Thread.currentThread().name}")
    }
    job.log()
    job.cancel()
    job.log()
    job.invokeOnCompletion {
        println("invokeOnCompletion")
    }


    // 这里启动一个协程
    println("In runBlocking: ${Thread.currentThread().name}")
    val deferred = async {
        // async 中启动另一个协程
        println("In async: ${Thread.currentThread().name}")
        5
    }
    println("After async: ${Thread.currentThread().name}")
    val result = deferred.await()
    println("Result is $result")
}

fun Job.log() {
    logX(
        """
        isActive = $isActive 
        isCancelled = $isCancelled 
        isCompleted = $isCompleted
    """.trimIndent()
    )
}

fun logX(any: Any) {
    println(
        """
================================
 $any
 Thread:${Thread.currentThread().name}
================================
    """.trimIndent()
    )
}
