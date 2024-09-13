package com.demo.delegate

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
        val message = "$thisRef, thank you for delegatign '${property.name}' to me!"
        println(message)
        return message;
    }

    operator fun setValue(thisRef: Any?,property: KProperty<*>,value:String){
        println("$value has been assigned to '${property.name}' in $thisRef")
    }
}

class Example{
    var p:String by Delegate()
}

val lazyValue:String by lazy {
    println("First init")
    "Hello"
}
        






