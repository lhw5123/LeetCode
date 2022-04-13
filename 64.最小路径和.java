/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (69.13%)
 * Likes:    1214
 * Dislikes: 0
 * Total Accepted:    347.2K
 * Total Submissions: 502.3K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int x = 1; x < cols; x++) {
            dp[0][x] = dp[0][x - 1] + grid[0][x];
        }
        for (int y = 1; y < rows; y++) {
            dp[y][0] = dp[y - 1][0] + grid[y][0];
        }
        for (int y = 1; y < rows; y++) {
            for (int x = 1; x < cols; x++) {
                dp[y][x] = Math.min(dp[y - 1][x] + grid[y][x], dp[y][x - 1] + grid[y][x]);
            }
        }
        // 打印路径
        dfs(dp, grid, rows - 1, cols - 1);
        return dp[rows - 1][cols - 1];
    }

    private void dfs(int[][] dp, int[][] grid, int y, int x) {
        if (y == 0 && x == 0) {
            System.out.printf("<-(%d,%d)", x, y);
            System.out.println();
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean f = (y == rows - 1 && x == cols - 1);
        if (y >= 1 && grid[y][x] + dp[y - 1][x] == dp[y][x]) {
            System.out.printf((f ? "" : "<-") + "(%d,%d)", x, y);
            dfs(dp, grid, y - 1, x);
        }
        if (x >= 1 && grid[y][x] + dp[y][x - 1] == dp[y][x]) {
            System.out.printf((f ? "" : "<-") + "(%d,%d)", x, y);
            dfs(dp, grid, y, x - 1);
        }
    }
}
// @lc code=end

