/**
 * Kotlin函数的例子
 */

package demo.function

import demo.`class`.User

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

class View{
   fun setClickListener(listener: (View) -> Unit) {
       listener(this)
   }

    fun onClick(listener: ClickListener){}
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

    val view = View()
    view.setClickListener { v ->
        println("View clicked")
    }

    // 通过object对象的方式
    view.onClick(object : ClickListener{
        override fun onClick(view: View) {
            println("View clicked")
        }
    })

    // 函数式接口，object可以省略
    view.onClick(ClickListener{view->
        println("View clicked")
    })

    // 函数式接口，可以转换为lambda，直接省略ClickListener
    view.onClick({view->
        println("View clicked")
    })

    // Lambda 只有一个参数的时候，可以使用it替代
    view.onClick({it->
        println("View clicked")
    })

    // Lambda 只有一个参数的时候，可以使用it替代，可以省略参数
    view.onClick({
        println("$it")
    })

    // Lambda 作为函数的最后一个参数的时候，大括号可以移到外面
    view.onClick(){
        println("$it")
    }

    // Lambda 作为函数的最后一个参数的时候，大括号可以移到外面，如果只有一个参数的可以省略括号
    view.onClick {
        println("$it")
    }


}

// 类似于java的FunctionalInterface
fun interface ClickListener {
    fun onClick(view: View)
}



fun test(view: View?) {
    view?.apply {
        setClickListener { v ->
            println("View clicked")
        }
    }

    view?.myApply{
        println("View clicked")
    }
}

fun View.myApply(block: View.()->Unit): View{
    block()
    return this
}

