package demo.`class`

class ObjectDemo {
    // 私有的函数，所以其返回类型是匿名对象类型
    private fun foo() = object {
        val x: String = "x"
    }

    //公有的函数，其返回类型是Any
    //如果继承了超类，那么返回值是其超类
    fun publicFoo() = object {
        val x: String = "X"
    }


    object o {
        fun create(): ObjectDemo {
            return ObjectDemo()
        }
    }
}

fun foo() {
    val adHoc = object {
        var x: Int = 1
        var y: Int = 3
    }

    println(adHoc.x + adHoc.y)
}

class DataProvider(private val name: String) {

}

object DataProviderManager {
    private val dataProviders: Collection<DataProvider> = ArrayList()
    fun registerDataProvider(provider: DataProvider) {

    }

    val allDataProviders: Collection<DataProvider>
        get() = dataProviders
}

class MouseEvent {

}

open class MouseAdapter {
    open fun mouseClicked(e: MouseEvent) {
    }

    open fun mouseEntered(e: MouseEvent) {

    }

}

object DefaultListener : MouseAdapter() {
    override fun mouseClicked(e: MouseEvent) {
    }

    override fun mouseEntered(e: MouseEvent) {

    }
}


fun main() {
    foo()
    DataProviderManager.registerDataProvider(DataProvider("foo"))
}
