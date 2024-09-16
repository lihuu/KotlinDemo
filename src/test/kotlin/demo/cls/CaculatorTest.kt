package demo.cls

import com.demo.calc.Calculator
import org.junit.jupiter.api.Assertions
import kotlin.test.Test

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2024/9/16
 */
class CalculatorTest {
    @Test
    fun testCalculate() {
        val calculator = Calculator()

        val result = calculator.calculate("1 + 1")

        Assertions.assertEquals(2, result)

    }
}