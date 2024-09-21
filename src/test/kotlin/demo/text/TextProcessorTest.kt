package demo.text

import com.demo.text.TextProcessor
import demo.generics.Box
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty
import kotlin.reflect.full.memberProperties
import kotlin.test.Test

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2024/9/19
 */
class TextProcessorTest {
    @Test
    fun testProcess() {
        val textProcessor = TextProcessor()
        val result = textProcessor.processText("hello world hello hello world")
        assertEquals(2, result.size)
        assertEquals(2, result.first().frequency)
        assertEquals(3, result.last().frequency)
    }

    @Test
    fun testItemDelegate() {
        val item = Item()
        item.total = 10
        assertEquals(10, item.total)
    }

    @Test
    fun testDelegate() {
        val owner = Owner()
        assertEquals("Hello", owner.text)
        owner.text = "World"
        assertEquals("World", owner.text)
    }

    @Test
    fun testSmartDelegate() {
        val owner = Owner()
        assertEquals("Normal", owner.normalText)
        assertEquals("Long", owner.longText)
    }
}

// 属性委托
class Item {
    var count: Int = 0
        get() {
            println("Get count,$field")
            return field
        }
        set(value) {
            println("Set count,new count is $value")
            field = value
        }

    var total: Int by ::count
}

class StringDelegate(private var s: String = "Hello") : ReadWriteProperty<Owner, String> {
    override operator fun getValue(thisRef: Owner, property: KProperty<*>): String {
        println("get value by StringDelegate: $s")
        return s
    }

    override operator fun setValue(thisRef: Owner, property: KProperty<*>, value: String) {
        println("set value by StringDelegate: $value")
        s = value
    }
}

class Owner {
    var text: String by StringDelegate()
    var normalText: String by SmartDelegator()
    var longText: String by SmartDelegator()
}

class SmartDelegator {
    operator fun provideDelegate(thisRef: Owner, prop: KProperty<*>): ReadWriteProperty<Owner, String> {
        println("delegate")
        return if (prop.name == "normalText") {
            StringDelegate("Normal")
        } else if (prop.name == "longText") {
            StringDelegate("Long")
        } else {
            StringDelegate()
        }
    }
}

class Model {
    val data: List<String> by ::_data

    private val _data: MutableList<String> = mutableListOf()

    fun loadData() {
        _data.add("Hello")
    }
}


open class TV {
    open fun turnOn() {}
}

class XiaoMiTV1 : TV() {
    override fun turnOn() {}
}

class Controller<T> {
    fun turnOn(tv: T) {

    }
}

fun foo(t: TV) {
}

fun test() {
    foo(XiaoMiTV1())

    buyer(Controller<TV>())
}

fun buyer(controller: Controller<in XiaoMiTV1>) {
    controller.turnOn(XiaoMiTV1())
}


open class Fruit

class Apple : Fruit()

open class Orange : Fruit()

class RedOrange : Orange()

class YellowOrange : Orange()


fun putFruit(fruit: Box<in Apple>) {
}

fun printFruit(fruit: Box<out Orange>) {}

class Watermelon

class X


class Test {
    @Test
    fun testGeneric() {
        putFruit(Box(Fruit()))
        putFruit(Box(Apple()))
        putFruit(Box(RedOrange()))
        putFruit(Box(RedOrange()))
        putFruit(Box(Watermelon()))
        putFruit(Box(X()))

        printFruit(Box(Orange()))
        printFruit(Box(YellowOrange()))
    }
}


fun main() {
    val student = Student("Tom", 99.5, 170)
    val school = School("PKU", "Beijing...")

    readMembers(student)
    readMembers(school)
}

fun readMembers(obj: Any) {
    obj::class.memberProperties.forEach {
        println("${obj::class.simpleName}.${it.name}=${it.getter.call(obj)}")
    }
    obj::class.members.forEach {
        if (it is KProperty<*>) {
            println("${obj::class.simpleName}.${it.name}=${it.call(obj)}")
        }
    }
    // 读取obj的所有成员属性的名称和值
}

data class Student(
    val name: String,
    val score: Double,
    val height: Int
)

data class School(
    val name: String,
    var address: String
)




