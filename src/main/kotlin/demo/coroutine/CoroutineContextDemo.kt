package demo.coroutine

import demo.utils.LogUtils.Companion.logM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

/**
 * @author lihu
 * @since 2023/2/5 14:16
 */

val myDispatcher = Executors.newFixedThreadPool(1) {
    Executors.defaultThreadFactory().newThread(it).apply { name = "MyDispatcher" }
}.asCoroutineDispatcher()

fun main() = runBlocking(myDispatcher) {
    val userInfo = getUserInfo()
    logM(userInfo)
}

suspend fun getUserInfo(): String {
    logM("Before IO Context.")
    withContext(Dispatchers.IO) {
        logM("In IO Context.")
        delay(1000L)
    }
    logM("After IO Context.")
    return "Silent"
}


