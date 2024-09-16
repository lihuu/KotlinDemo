package com.demo.objects

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2024/9/16
 */

interface A {
    fun a()
}

interface B {
    fun b()
}

abstract class Main {
    abstract fun main()
}


fun main() {
    val item = object : Main(), A, B {
        override fun main() {
            TODO("Not yet implemented")
        }

        override fun a() {
            TODO("Not yet implemented")
        }

        override fun b() {
            TODO("Not yet implemented")
        }

    }
}


