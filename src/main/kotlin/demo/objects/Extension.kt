package com.demo.objects

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2024/9/16
 */
class Extension {
    fun fuck() {
        println("Fuck")
    }
}

fun Extension.test() {
    this.fuck()
    println("Extension test")
}

fun Extension?.hello() {
    this?.fuck()
    println("Extension hello")
}

