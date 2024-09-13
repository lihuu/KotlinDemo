package com

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2024/7/19
 */
// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

fun double(x: Int): Int {
    return x * 2
}

fun <K, V> map(key: K, mapper: (key: K) -> V): V {
    return mapper(key)
}

fun printAll(vararg messages: String) {
    for (m in messages) println(m)
}

fun printAllWithPrefix(vararg messages: String, prefix: String = "Info") {
    for (m in messages) println(prefix + m)
}

class Customer {
    infix fun hasEmail(email: String) = true
}


fun log(vararg entries: String) {
    println("Log:")
    printAll(*entries)                                             // 5
}


fun main() {
    val function = { x: Int, y: Int -> x + y }
    val sum: (x: Int, y: Int) -> Int = function

    val result = sum(1, 2)
    println(result)

    // TIP Press <shortcut actionId="ShowIntentionActions"/>
    // with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    val name = "Kotlin"
    println("Hello, $name!")

    println(double(2))


    val pair = "Ferrari" to "Katrina"                          // 3
    println(pair)

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
        println(map(i) { it * 2 })
    }

    operator fun Int.times(str: String) = str.repeat(this)       // 1
    println(2 * (2 * "Bye "))                                          //

    operator fun String.get(range: IntRange) = substring(range)  // 3
    val str = "Always forgive your enemies; nothing annoys them so much."
    println(str[0..14])

    printAll("Hello", "Hallo", "Salut", "Hola", "你好")

    printAllWithPrefix("Hello", "Hallo", "Salut", "Hola", "你好", prefix = "Greeting: ")
    printAllWithPrefix("Hello", "Hallo", "Salut", "Hola", "你好")
    log("Hello", "Hallo", "Salut", "Hola", "你好")
}