package demo.generics

/**
 * Kotlin也会进行类型擦除
 */

class GenericsDemo {
}

class Box<T>(t: T) {
    val value = t
}

interface Source<out T> {
    fun nextT(): T
}

fun demos(strs: Source<String>) {
    val objects: Source<Any> = strs
}

interface Comparable<in T> {
    //operator这个是操作符重载，compareTo是个什么操作符呀
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 拥有类型 Double，它是 Number 的子类型
    // 因此，我们可以将 x 赋给类型为 Comparable <Double> 的变量
    val y: Comparable<Double> = x // OK！
}

fun main() {
    println("This is a generics demo")
    val box = Box(1)
}