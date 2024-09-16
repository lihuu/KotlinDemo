package com.demo.calc

import kotlin.system.exitProcess

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2024/9/16
 */

private const val HELP = "请输入标准的算式，并且按回车; \n" + "比如：1 + 1，注意符合与数字之间要有空格。\n" + "输入exit，退出程序。"

class Calculator {
    fun start() {
        while (true) {
            // 初始化，打印提示信息
            println(HELP)

            val input = readLine() ?: continue
            if (input == "exit") exitProcess(0)

            calculate(input)?.let {
                println("$input = $it")
            } ?: {
                println("输入的算式有误，请重新输入")
            }
        }
    }

    fun calculate(input: String): Int? {
        val inputList = input.split(" ")
        if (inputList.size != 3) return null
        return Expression(inputList[0].toInt(), getOperator(inputList), inputList[2].toInt())
            .calculate()
    }


    private fun getOperator(inputList: List<String>): Operator {
        return Operator.values().find { it.value == inputList[1] }?.let {
            return it
        } ?: throw IllegalArgumentException("不支持的运算符")
    }

}


fun main() {
    Calculator().start()
}

data class Expression(val left: Int, val operator: Operator, val right: Int) {
    fun calculate(): Int {
        return operator.apply(left, right)
    }
}

interface Operation {
    fun apply(left: Int, right: Int): Int
}

enum class Operator(val value: String) : Operation {
    ADD("+") {
        override fun apply(left: Int, right: Int): Int {
            return left + right
        }
    },
    SUB("-") {
        override fun apply(left: Int, right: Int): Int {
            return left - right
        }
    },
    MUL("*") {
        override fun apply(left: Int, right: Int): Int {
            return left * right
        }
    },
    DIV("/") {
        override fun apply(left: Int, right: Int): Int {
            return left / right
        }
    }
}