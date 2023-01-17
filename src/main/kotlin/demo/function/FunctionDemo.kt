/**
 * Kotlin函数的例子
 */

package demo.function

//Kotlin的函数
fun sum(a: Int, b: Int): Int {
    return a + b
}

/**
 * 没有返回值的可以函数的返回值类型使用Unit，这个Unit可以省略
 * 函数的参数可以使用默认的值
 */
fun printNumber(a: Int = 0): Unit {
    println(a)
}

/**
 * 如果一个默认参数在一个无默认值的参数之前，那么该默认值只能通过使用具名参数调用该函数来使用
 * 例如printNumber(b = 3) 这样调用的时候会使用默认值a=0
 */
fun printNumber(a: Int = 0, b: Int) {
    println("First parameter: $a")
    println("Second parameter: $b")
}

fun foo(a: Int = 0, b: Int = 1, callback: () -> Unit) {
    callback()
}

//单函数式表达式，返回值的类型可以通过编译器推断出来，所以是可选的，等价于
//fun double(x: Int) = x * 2
fun double(x: Int): Int = x * 2

//函数可以

//可变数量的函数类似于java中的。。。
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) {
        result.add(t)
    }
    return result
}

//可以这么去定义一个函数，这个算是闭包么
val c = { println("Hello") }

fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}

//这个是Kotlin的main函数
//args可以省略
fun main() {
    println(sum(1, 2))
    printNumber()
    printNumber(2)
    printNumber(1, 2)
    printNumber(b = 3)
    println("Hello World!")

    foo {
        //这个东西在gradle中应该会大量使用
        println("在参数括号的外面传一个lambda")
    }
    foo(callback = { println("在参数括号中传入一个lambda") })
    c()

    val list = asList(1, 2, 3)
    println(list)
    val name = "Hello.java"
    println(name.subSequence(0, name.indexOf(".")))

}