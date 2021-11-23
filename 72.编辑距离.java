/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();

        if (n1 * n2 == 0) {
            return n1 + n2;
        }

        // dp[i][j] 表示 A 的前 i 个字母和 B 的前 j 个字母之前的编辑距离。
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < n1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n2 + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }

        return dp[n1][n2];
    }
}
// @lc code=end

