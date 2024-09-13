package demo.cls

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertIterableEquals
import kotlin.test.Test

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2024/9/13
 */
class KotlinScopeTest {
    @Test
    fun testLetScope(){
        // 上下文对象通过it参数传入
        // 返回值是lambda表达式的结果
        val numbers = mutableListOf("one", "two", "three", "four", "five")
        val resultList = numbers.map { it.length }.filter { it > 3 }
            .let {
                // let 返回的是最后一行的结果
                println(it)
                it
            }
        println(resultList)
        assertIterableEquals(listOf(5, 4, 4), resultList)
    }

    @Test
    fun testAlsoScope(){
        // 上下文对象通过it参数传入
        // 返回值是上下文对象
        val numbers = mutableListOf("one", "two", "three", "four", "five")
        val resultList = numbers.map { it.length }.filter { it > 3 }
            .also {
                // let 返回的是最后一行的结果
                println(it)
            }
        println(resultList)
        assertIterableEquals(listOf(5, 4, 4), resultList)
    }

    @Test
    fun testWithScope(){
        // 上下文对象通过this参数传入
        // 返回值是lambda表达式的结果
        val numbers = mutableListOf("one", "two", "three")
        val result = with(numbers) {
            arrayOf(
                "'with' is called with argument $this",
                        "It contains $size elements",
                        "The first element is ${first()}",
                        "The last element is ${last()}"
            )
        }

        assertArrayEquals(
            arrayOf(
                "'with' is called with argument [one, two, three]",
                "It contains 3 elements",
                "The first element is one",
                "The last element is three"
            ),
            result
        )
    }

    @Test
    fun testRunScope(){
        // 上下文对象通过this参数传入
        // 返回值是lambda表达式的结果
        val numbers = mutableListOf("one", "two", "three")
        val result = numbers.run {
            arrayOf(
                "'run' is called with argument $this",
                "It contains $size elements",
                "The first element is ${first()}",
                "The last element is ${last()}"
            )
        }

        assertArrayEquals(
            arrayOf(
                "'run' is called with argument [one, two, three]",
                "It contains 3 elements",
                "The first element is one",
                "The last element is three"
            ),
            result
        )
    }

}