import com.map
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import kotlin.test.Test

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2024/7/21
 */
class BasicTest {

    class MutableStack<E>(vararg elements: E) {
        private val elements = elements.toMutableList();

        companion object Name {
            const val CLASS_NAME = "MutableStack"
        }

        fun push(element: E) = elements.add(element)

        fun pop(): E = elements.removeAt(elements.size - 1)

        fun peek(): E = elements.last()

        fun isEmpty() = elements.isEmpty()

        override fun toString() = "MutableStack(${elements.joinToString()})"
        fun size() = elements.size

    }

    fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {  // 1
        return operation(x, y)                                          // 2
    }

    fun sum(x: Int, y: Int) = x + y                                     // 3

    data class User(val name: String, val age: Int) {
        constructor() : this("", 0)
    }

    data class Person(var name: String, var age: Int) {
        constructor() : this("", 0)

    }

    fun User.isAudit() = this.age > 18

    data object Singleton {
        val name = "Singleton"
    }

    @Test
    fun test_data_usage() {
        val user = User("Alex", 18)

        assertEquals("Alex", user.name)
        assertEquals(18, user.age)
        assertFalse(user.isAudit())
        user.run {
            assertEquals("Alex", this.name)
            this.name
        }.let { println(it) }

        with(user) {
            println("$name,$age")
        }

        println(Person().apply {
            name = "Alex"
            age = 20
        }.toString())

        Person("Li", 18).also { println(it.toString()) }


    }


    @Test
    fun test_calculate() {
        val value = calculate(1, 2, ::sum)

        assertEquals(3, value)

        assertEquals(2, calculate(1, 2) { x, y -> x * y })
    }

    @Test
    fun should_return_same() {
        val mapper: (key: String) -> String = { it ->
            "$it,World"
        }
        val result = map("Hello", mapper)

        map("hello") {}.let {

        }
        assertEquals("Hello,World", result)
    }

    @Nested
    inner class MutableStackTask {
        private var mutableStack: MutableStack<String>? = null

        @BeforeEach
        fun setUp() {
            mutableStack = MutableStack()
            println(MutableStack.CLASS_NAME)
        }

        @Test
        fun should_return_true_when_stack_is_empty() {
            val empty = mutableStack?.isEmpty()
            if (empty != null) {
                Assertions.assertTrue(empty)
            };
        }
    }

    @Test
    fun test_collection() {
        val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)
        val sudoers: List<Int> = systemUsers

        fun addSystemUser(newUser: Int) {
            systemUsers.add(newUser)
        }

        fun getSystemUser(): List<Int> {
            return sudoers
        }

        addSystemUser(4)
        assertIterableEquals(listOf(1, 2, 3, 4), systemUsers)
        assertIterableEquals(listOf(1, 2, 3, 4), getSystemUser())
    }

    class LazySample {
        init {
            println("created!")
        }

        val lazyStr: String by lazy {
            println("computed!")
            "my lazy"
        }
    }

    data class Customer(val name: String, var email: String)

    @Test
    fun test_lazy() {
        val sample = LazySample()
        println("Should assign value when get property")
        println("lazyStr = ${sample.lazyStr}")
        println(" = ${sample.lazyStr}")
    }

    @Test
    fun test_customer() {
        val customer = Customer("Alex", "alex@gmail.com")
        assertEquals("Alex", customer.name)
        assertEquals("alex@gmail.com", customer.email)

        customer.email = "lihu@gmail.com"
        assertEquals("lihu@gmail.com", customer.email)
    }

    private val regex = "\\d{6}|\\d{4}".toRegex();

    private fun extractVerificationCode(text: String): String? {
        val matchResult = regex.find(text)
        return matchResult?.value
    }

    @Test
    fun test_extract_verification_code() {
        val text = "Verification code: 123456. Your code is valid for 10 minutes."
        assertEquals("123456", extractVerificationCode(text))

        val text2 = "Verification code: 1234. Your code is valid for 10 minutes."
        assertEquals("1234", extractVerificationCode(text2))
    }

}