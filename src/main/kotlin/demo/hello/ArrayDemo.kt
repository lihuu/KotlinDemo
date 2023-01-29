package demo.hello

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2023/1/29
 */

fun main() {
    val array = arrayOf("apple", "pear")
    println("Array size is ${array.size}")
    println("First element is ${array[0]}")
    val list = listOf("apple", "pear")
    println("List size is ${list.size}")
    println("First element is ${list[1]}")
    println(helloFunction("Kotlin"))
    println(hello(name = "Kotlin"))
}

fun helloFunction(name: String): String {
    return "Hello, $name"
}

fun biggerThanOne(i: Int) {
    if (i > 1) {
        print("Big")
    } else {
        print("Small")
    }
}

fun biggerThanOne1(i: Int) {
    val message = if (i > 1) "Big" else "Small"
    print(message)
}

/**
 * 可以省略花括号
 */
fun hello(name: String): String = "Hello, $name"

fun hello1(name: String) = "Hello, $name"