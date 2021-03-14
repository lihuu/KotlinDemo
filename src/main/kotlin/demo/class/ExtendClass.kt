package demo.`class`

//扩展函数，类似于JavaScript的在原型链上面添加函数的功能
//Kotlin真的是糅合了好几门语言呀
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

class ExtendClass {
}

open class Shape

class Rectangle : Shape()

fun Shape.getName() = "Shape"

fun Rectangle.getName() = "Rectangle"


fun printClassName(s: Shape) {
    //需要注意的是，扩展函数式静态绑定的，在这个代码中，会返回"Shape"
    //不是多态，不是根据运行时s的类型来决定的
    println(s.getName())
}

fun main() {
    val list = mutableListOf(1, 2, 3)
    println("Before swap : $list")
    list.swap(2, 1)
    println("After  swap : $list")
}