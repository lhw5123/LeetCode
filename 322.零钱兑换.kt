/*
 * @lc app=leetcode.cn id=322 lang=kotlin
 *
 * [322] 零钱兑换
 * 
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 */

// @lc code=start
class Solution {
    /**
     * 思路：动态规划，即通过子问题的最优解得到整个问题的最优解。
     * 
     * @param coins: 具有的硬币种类。
     * @param amount: 要组成的总面额。
     */
    fun coinChange(coins: IntArray, amount: Int): Int {
        // dp[i] 代表组成 i 元钱所需的最少硬币个数。
        val dp = IntArray(amount + 1) {
            amount + 1
        }
        dp[0] = 0
        for (i in 1..amount) {  // i 代表金额
            for (coin in coins) {
                // coin <= i 代表金额 i 可由 [i - coin] + [coin] 组成。
                if (coin <= i) {
                    dp[i] = if (dp[i] <= (dp[i - coin] + 1)) {
                        dp[i]
                    } else {
                        dp[i - coin] + 1
                    }
                }
            }
        }
        return if (dp[amount] > amount) {   // 因为初始化为了 [amount + 1]，所以当 dp[amount] > amount 时代表无解。
            -1
        } else {
            dp[amount]
        }
    }
}
// @lc code=end

