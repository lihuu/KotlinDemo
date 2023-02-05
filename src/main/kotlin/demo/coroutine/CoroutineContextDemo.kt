package demo.coroutine

import demo.utils.LogUtils
import demo.utils.LogUtils.Companion.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * @author lihu
 * @since 2023/2/5 14:16
 */

fun main() = runBlocking { 
    val userInfo = getUserInfo()
    log(userInfo)
}

suspend fun getUserInfo():String{
    log("Before IO Context.")
    withContext(Dispatchers.IO){
        log("In IO Context.")
        delay(1000L)
    }
    log("After IO Context.")
    return "Silent"
}