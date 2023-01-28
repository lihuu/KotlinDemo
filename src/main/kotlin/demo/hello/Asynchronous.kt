package demo.hello

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.log

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2023/1/28
 */


suspend fun main() {
    val start = System.currentTimeMillis()

    coroutineScope {
        for (i in 1..10) {
            launch {
                delay(3000L - i * 300)
                log(start, "Countdown: $i")
            }
        }
    }
}

fun log(start: Long, msg: String) {
    println("$msg (on ${Thread.currentThread().name}) after ${(System.currentTimeMillis() - start) / 1000F}s")
}