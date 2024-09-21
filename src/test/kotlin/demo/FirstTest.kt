package demo

import kotlin.test.Test

/**
 * @author lihu
 * @since 2023/1/17 14:46
 */
class FirstTest {
    @Test
    fun testFist() {
        val str = "String"
        assert("String" == str)
    }

    @Test
    fun testCompanionObject() {
        //相当于MyClass.Companion.hello()
//        val hello = MyClass.hello("lihu")
//        assert(hello == "Hello,lihu")
    }

    @Test
    fun testObject() {
//        val hello = MyClass.obj.hello("lihu")
//        assert(hello == "Hello,lihu")
    }

}

/**
 * 在Kotlin中，open关键字用于修饰类和方法，表示这些类或方法可以被继承或重写。与Java不同，Kotlin中的类和方法默认是不可继承的（即final），需要显式声明为open才能允许子类继承或覆盖。
 *
 * open 关键字的作用
 * 用于类：默认情况下，Kotlin中的类是final的，这意味着它们不能被继承。使用open关键字修饰类后，该类才能被其他类继承。
 *
 * 用于方法或属性：Kotlin中类的方法和属性默认也是final的，不能被子类重写。使用open关键字修饰后，方法或属性可以被子类重写。
 */

abstract class Animal{
    abstract fun makeSound(): String;
}
class Dog: Animal() {
    override fun makeSound():String {
        return "Wang"
    }
}

class Cat: Animal() {
    override fun makeSound(): String {
        return "Miao"
    }
}

class ReifiedTest{
   inline fun <reified T: Animal> makeSound(animal: T){
       when(animal){
           is Dog -> println(animal.makeSound())
           is Cat -> println(animal.makeSound())
           else -> println("Unknown")
       }
   }

    @Test
    fun test(){
        makeSound(Dog())
        makeSound(Cat())
    }

    fun findValue(list:List<String>,target:String){
        list.find { it == target }?.let {
            println("Found")
        }?:println("Not Found")
    }

    @Test
    fun testNullable(){
        findValue(listOf("A","B","C"),"B")
    }
}


class MyClass {
    companion object {
        fun hello(name: String): String {
            return "Hello,$name";
        }
    }

    object obj {
        fun hello(name: String): String {
            return "Hello,$name";
        }
    }
}