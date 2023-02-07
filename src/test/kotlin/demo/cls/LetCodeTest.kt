package demo.cls

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

/**
 * @author lihu
 * @since 2023/2/7 14:26
 */
class LetCodeTest {
    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     */

    private fun removeElement(list: Array<Int>, target: Int): Int {
        var s = 0
        val size = list.size
        for (f in 0 until size) {
            if (list[f] != target) {
                list[s++] = list[f]
            }
        }
        return s
    }

    @Test
    fun testRemoveElement() {
        val nums = arrayOf(3, 2, 2, 3)
        val result = removeElement(nums, 3)
        assertEquals(2, result)
        val subList = nums.sliceArray(IntRange(0, result - 1))
        assertContentEquals(arrayOf(2, 2).toIntArray(), subList.toIntArray())
    }

}