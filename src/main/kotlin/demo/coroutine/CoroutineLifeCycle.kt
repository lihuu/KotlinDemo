package com.demo.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2024/9/20
 */

fun main() = runBlocking {
    val job = launch {
        logX("First coroutine start!")
        delay(1000L)
        logX("First coroutine end!")
    }

    job.log()
    job.join()
    job.log()
    // job2没有执行

    val job2 = launch(job) {
        logX("Second coroutine start!")
        delay(1000L)
        logX("Second coroutine end!")
    }
    job2.log()
    job2.join()
    job2.log()
    logX("Process end!")
}