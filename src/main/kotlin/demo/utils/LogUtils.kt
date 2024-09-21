package demo.utils

/**
 * @author lihu
 * @since 2023/2/5 14:18
 */
class LogUtils {
    companion object {
        fun log(message: String) {
            println(message)
        }

        fun logM(message: String) {
            println(
                """
                =====================================
                $message
                Thread: ${Thread.currentThread().name}
                =====================================
                """.trimIndent()
            )
        }
    }
}