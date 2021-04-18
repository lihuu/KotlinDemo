package demo.`class`

import kotlin.reflect.KProperty

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

//属性的委托

class Delegate{
    operator fun getValue(thisRef: Any?,property:KProperty<*>):String{
        return "$thisRef, thank you for delegatign '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?,property: KProperty<*>,value:String){
        println("$value has been assigned to '${property.name}' in $thisRef")
    }
}

class Example{
    var p:String by Delegate()
}
        




fun main() {
    val b = BaseImpl(1)
    Derived(b).print()
}



