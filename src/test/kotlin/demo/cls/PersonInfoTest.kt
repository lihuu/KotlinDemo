package demo.cls

import demo.`class`.PersonInfo
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * @author lihu
 * @since 2023/2/5 17:10
 */
class PersonInfoTest {
    @Test
    fun test(){
        val personInfo = PersonInfo("lihu", 30)
        assertEquals("lihu",personInfo.name)
        assertEquals(true,personInfo.isAdult)
    }
}