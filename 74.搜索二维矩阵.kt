/*
 * @lc app=leetcode.cn id=74 lang=kotlin
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size // 行数
        if (m == 0) {
            return false
        }
        val n = matrix[0].size  // 列数
        // 二分查找。row = idx / n, col = idx % n
        var left = 0
        var right = m * n - 1
        while (left <= right) {
            val pivotIdx = left + (right - left) / 2
            val pivotElement = matrix[pivotIdx / n][pivotIdx % n]
            when {
                target > pivotElement -> {
                    left = pivotIdx + 1
                }
                target < pivotElement -> {
                    right = pivotIdx - 1
                }
                else -> {
                    return true
                }
            }
        }
        return false
    }
}
// @lc code=end

