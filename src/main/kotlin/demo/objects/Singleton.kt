package com.demo.objects

import demo.`class`.User

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2024/9/16
 */

// 单例模式
object UserMapper {
    val user by lazy {
        loadUser()
    }

    fun login() {
        println("login success")
        println("user: ${user.name}")
    }

    private fun loadUser(): User1 {
        println("load user")
        return User1.create("lihu")
    }
}

// 伴生对象 相当于 静态内部类
// companion object {
class Person {
    companion object InnerSingleton {
        fun foo() {}
    }
}

class Hello(world: String) {
    fun test() {
    }
}


class User1 private constructor(val name: String) {
    companion object {
        @JvmStatic
        fun create(name: String): User1 {
            return User1(name)
        }
    }
}


fun main() {
    UserMapper.login()

}




