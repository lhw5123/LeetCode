/*
 * @lc app=leetcode.cn id=69 lang=kotlin
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    /**
     * 方法：
     * 1. 暴力求解
     * 2. Binary search
     * 3. 牛顿迭代法
     */
    fun mySqrt(x: Int): Int {
        var start = 1
        var end = x

        while (start <= end) {
            val mid = start + (end - start) / 2
            if (mid > x / mid) {    // 注意 mid * mid 可能超出 int 的范围。所以可以改成除法：mid > x / mid
                end = mid - 1
            } else if (mid * mid < x) {
                start = mid + 1
            } else {
                return mid
            }
        }

        return end
    }
}
// @lc code=end

