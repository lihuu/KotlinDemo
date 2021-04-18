package demo.`class`

class DelegateDemo {
}

//Kotlin 支持原生的委托模式

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        print(x)
    }
}
class Derived(b: Base) : Base by b

//




fun main() {
    val b = BaseImpl(1)
    Derived(b).print()
}



