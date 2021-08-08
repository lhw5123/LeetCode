/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 从右上角开始遍历。
        int x = matrix[0].length - 1;
        int y = 0;

        while (x >= 0 && y < matrix.length) {
            if (target == matrix[y][x]) {
                return true;
            }
            if (target < matrix[y][x]) {
                x--;
            } else {
                y++;
            }
        }

        return false;
    }
}
// @lc code=end

