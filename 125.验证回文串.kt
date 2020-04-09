/*
 * @lc app=leetcode.cn id=125 lang=kotlin
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    fun isPalindrome(s: String): Boolean {
        val charArr = s.toLowerCase().toCharArray()
        var start = 0
        var end = charArr.size - 1
        var isPalindrome = true

        while (start < end) {
            if (charArr[start].isLetterOrDigit() && charArr[end].isLetterOrDigit()) {
                if (charArr[start] == charArr[end]) {
                    start++
                    end--
                } else {
                    isPalindrome = false
                    break
                }
            } else if (charArr[start].isLetterOrDigit()) {
                end--
            } else if (charArr[end].isLetterOrDigit()) {
                start++
            } else {
                start++
                end--
            }
        }
        return isPalindrome
    }
}
// @lc code=end

