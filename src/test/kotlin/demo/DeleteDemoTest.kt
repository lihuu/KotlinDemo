package demo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import kotlin.properties.Delegates
import kotlin.test.Test

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2024/9/13
 */

class DeleteDemoTest{
    @Test
    fun testLazyValue(){
        val lazyValue: String by lazy {
            println("computed!")
            "Hello"
        }
        println(lazyValue)
        println(lazyValue)
    }

    @Test
    fun testObservable(){
        var name: String by Delegates.observable("no name") { prop, old, new ->
            println("$old -> $new")
        }
        name = "first"
        name = "second"
    }

    @Test
    fun testMapProperty(){
        class User(val map:Map<String,Any?>){
            val name: String by map
            val age:Int by map
        }

        val user = User(mapOf(
            "name" to "John Doe",
            "age" to 25
        ))

        assertEquals("John Doe",user.name)
        assertEquals(25,user.age)
    }

    @Test
    fun testMutableUser(){
        class MutableUser(val map: MutableMap<String,Any?>){
            var name: String by map
            var age:Int by map
        }

        val user = MutableUser(mutableMapOf(
            "name" to "John Doe",
            "age" to 25
        ))

        assertEquals("John Doe",user.name)
        assertEquals(25,user.age)

        user.name = "Jane"
        user.age = 26

        assertEquals("Jane",user.name)
        assertEquals(26,user.age)
    }



}