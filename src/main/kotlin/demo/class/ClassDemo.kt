package demo.`class`

/**
 * Kotlin中所有的类都会默认继承一个共同的超类Any
 * Any 有三个方法：equals()、 hashCode() 与 toString()。因此，为所有 Kotlin 类都定义了这些方法。
 * 默认情况下，Kotlin 类是最终（final）的：它们不能被继承。 要使一个类可继承，请用 open 关键字标记它。
 */
class ClassDemo {
}


/**
 * 由于默认的情况下类是不能继承的，在类的申明前面加上open关键字可以开放继承
 */
abstract class Animal(color: String = "") {
    abstract fun run()
}

class Cat//没有显式的主构造函数，需要默认super
    (weight: Double) : Animal("Yello") {
    init {
        println("")
    }

    override fun run() {
        println("Cat run .")
    }
}

open class Dog(color: String) : Animal() {

    override fun run() {
        println("Dog run .")
    }

}

/**
 * 中华田园犬
 */
class ChineseRuralDog(color: String) : Dog(color) {
    constructor(color: String, age: Int) : this(color) {
    }
}


/**
 * 主构造函数和类的声明放在一行，其中主构造函数的constructor关键字是可以省略的
 * 次构造函数，需要放在类的里面，并且需要调用主构造函数才行，如果一个类中没有显示声明主构造函数，也会调用
 *
 */
class User constructor(private val id: Int, private val name: String) {

    init {
        //主构造函数不能包含任何的代码，初始化的代码可以放在这个init代码块中
        println("User init : $id, $name")
    }

    constructor(id: Int, name: String, age: Int) : this(id, name) {
        println("User init: $id, $name, $age")
    }

}


class PersonInfo(val name: String, private val age: Int) {
    val isAdult: Boolean
        get() = age > 18

}

fun main() {
    val user = User(1, "lihu")
    User(1, "lihu", 18)
    Dog("black").run()
}

