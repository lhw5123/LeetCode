/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    // 动态规划
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }

        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                if (matrix[y][x] == '1') {
                    if (x == 0 || y == 0) {
                        dp[y][x] = 1;
                    } else {
                        dp[y][x] = Math.min(Math.min(dp[y-1][x], dp[y][x-1]), dp[y-1][x-1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[y][x]);
                }
            }
        }
        
        return maxSide * maxSide;
    }
}
// @lc code=end

