/*
 * @lc app=leetcode.cn id=227 lang=kotlin
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    fun calculate(s: String): Int {
        val t = s.replace(" ", "")
        // 注意：是用链表实现栈的功能。
        val digits = mutableListOf<Int>()
        val opors = mutableListOf<Char>()
        var i = 0
        while (i < t.length) {
            var num = 0
            while (i < t.length && t[i].isDigit()) {
                num = num * 10 + Character.getNumericValue(t[i++])
            }
            digits.add(0, num)
            if (i >= t.length) {
                break
            }
            while (true) {
                if (opors.isEmpty()) {
                    opors.add(0, t[i++])
                    break
                } else if (oporLevel(t[i]) > oporLevel(opors.first())) {
                    opors.add(0, t[i++])
                    break
                } else {
                    val r = digits.removeAt(0)
                    val l = digits.removeAt(0)
                    val op = opors.removeAt(0)
                    digits.add(0, cal(l, op, r))
                }
            }
        }
        while (opors.isNotEmpty()) {
            val r = digits.removeAt(0)
            val l = digits.removeAt(0)
            val op = opors.removeAt(0)
            digits.add(0, cal(l, op, r))
        }
        return digits.removeAt(0)    
    }

    /**
    * Note：除法仅保留整数部分。
    */
    fun cal(a: Int, op: Char, b: Int): Int {
        return when (op) {
            '+' -> a + b
            '-' -> a - b
            '*' -> a * b
            '/' -> a / b
            else -> 0
        }
    }

    fun oporLevel(opor: Char): Int {
        return when (opor) {
            '+', '-' -> 1
            '*', '/' -> 2
            else -> return 0
        }
    }
}
// @lc code=end

