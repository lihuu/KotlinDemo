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
}