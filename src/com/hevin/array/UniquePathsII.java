package com.hevin.array;

/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 */
public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int i = 0; i < width; i++) {
                if (row[i] == 1) {
                    dp[i] = 0;
                } else if (i > 0){
                    dp[i] += dp[i - 1];
                }
            }
        }
        return dp[width - 1];
    }
}
