package demo.`class`

interface MyInterface {

    val prop: Int //抽象的

    val propertyWithImplements: String get() = "foo"


    fun foo()
    fun bar() {
        //接口可以有方法图
    }
}

interface InterfaceTest {
    fun test()
}


//可以实现多个接口
class MyClass(override val prop: Int) : MyInterface, InterfaceTest {

    var user: User = User(1, "li")

    override fun foo() {
        TODO("Not yet implemented")
    }

    override fun test() {
        println("Test")
    }
}

interface Named {
    val name: String
}


interface Person : Named {
    val firstName: String
    val lastName: String

    override val name: String get() = "$firstName $lastName"
}

class Position


class Employee(override val firstName: String, override val lastName: String, val position: Position) : Person {
}

interface A {
    fun foo() {
        print("A")
    }

    fun bar()
}

interface B {
    fun foo() {
        print("B")
    }

    fun bar() {
        print("bar")
    }
}

class C : A {
    override fun bar() {
        print("bar")
    }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
//        super.bar()
    }
}

//### 函数式接口
//
fun interface KRunnable {
    fun invoke()
}

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}


fun main() {
    val employee = Employee("li", "hu", Position())
    println(employee.name)

//    val isEven = object : IntPredicate {
//        override fun accept(i: Int): Boolean {
//        }
//    }

    val isEvent = IntPredicate { it % 2 == 0 }

    println("Is 7 event? ${isEvent.accept(7)}")

}



