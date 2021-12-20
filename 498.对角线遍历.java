/*
 * @lc app=leetcode.cn id=498 lang=java
 *
 * [498] 对角线遍历
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int rows = mat.length;
        int cols = mat[0].length;
        int x = 0, y = 0;
        int direction = 1;  // 1: 向右上；0: 向左下。
        int[] res = new int[rows * cols];
        int r = 0;
        while (x < cols && y < rows) {
            res[r] = mat[y][x];
            r++;

            int new_x = x + (direction == 1 ? 1 : -1);
            int new_y = y + (direction == 1 ? -1 : 1);
            // 判断在不在边界内。
            if (new_x < 0 || new_x == cols || new_y < 0 || new_y == rows) {
                if (direction == 1) {
                    y += (x == cols - 1 ? 1 : 0);
                    x += (x < cols - 1 ? 1 : 0);
                } else {
                    x += (y == rows - 1 ? 1 : 0);
                    y += (y < rows - 1 ? 1 : 0);
                }

                // Flip the direction.
                direction = 1 - direction;
            } else {
                x = new_x;
                y = new_y;
            }
        }
        return res;
    }
}
// @lc code=end

