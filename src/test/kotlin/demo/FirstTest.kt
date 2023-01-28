package demo

import kotlin.test.Test

/**
 * @author lihu
 * @since 2023/1/17 14:46
 */
class FirstTest {
    @Test
    fun testFist(){
        val str = "String"
        assert("String" == str)
    }
    
    @Test
    fun testCompanionObject(){
        //相当于MyClass.Companion.hello()
        val hello = MyClass.hello("lihu")
        assert(hello=="Hello,lihu")
    }
    
    @Test
    fun testObject(){
        val hello = MyClass.obj.hello("lihu")
        assert(hello=="Hello,lihu")
    }
}

class MyClass{
    companion object {
        fun hello(name: String):String{
            return "Hello,$name";
        }
    }
    
    object obj {
        fun hello(name: String):String{
            return "Hello,$name";
        }
    }
}