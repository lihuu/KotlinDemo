package demo.hello

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2023/1/29
 */

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    GlobalScope.launch {
        println("Coroutine started!")
        delay(1000L)
        println("Hello world!")
        println("Current Thread ${Thread.currentThread().name}")
    }
    println("After launch!")
    Thread.sleep(2000L)
    println("Main Thread ${Thread.currentThread().name}")
    println("Process end!")
}