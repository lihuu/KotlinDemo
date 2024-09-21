package com.demo.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2024/9/20
 */
fun main() = runBlocking {
    val sequence = getSequence()
    printSequence(sequence)

    val channel = getProducer(this)
    testCustomer(channel)
}

fun getSequence() = sequence<Int> {
    println("Add 1")
    yield(1)
    println("Add 2")
    yield(2)
    println("Add 3")
    yield(3)
    println("Add 4")
    yield(4)
}

fun printSequence(sequence: Sequence<Int>) {
    val iterator = sequence.iterator()
    val i = iterator.next()
    println("Get$i")
    val j = iterator.next()
    println("Get$j")
    val k = iterator.next()
    println("Get$k")
    val m = iterator.next()
    println("Get$m")
}

@OptIn(ExperimentalCoroutinesApi::class)
fun getProducer(scope: CoroutineScope) = scope.produce<Int> {
    println("Add 1")
    send(1)
    println("Add 2")
    send(2)
    println("Add 3")
    send(3)
    println("Add 4")
    send(4)
}

suspend fun testCustomer(channel: ReceiveChannel<Int>) {
    delay(100)
    val i = channel.receive()
    println("Receive$i")
    delay(100)
    val j = channel.receive()
    println("Receive$j")
    delay(100)
    val k = channel.receive()
    println("Receive$k")
    delay(100)
    val m = channel.receive()
    println("Receive$m")
}

