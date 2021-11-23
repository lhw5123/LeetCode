/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 注意：dp[0] 一定要是 0
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount + 1;
        }

        for (int amt = 1; amt <= amount; amt++) {
            for (int c = 0; c < coins.length; c++) {
                int coin = coins[c];
                if (coin <= amt) {
                    if (dp[amt] > dp[amt - coin] + 1) {
                        dp[amt] = dp[amt - coin] + 1;
                    }
                }
            }
        }

        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];
    }
}
// @lc code=end

