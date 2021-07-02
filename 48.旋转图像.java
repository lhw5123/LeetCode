import javax.swing.plaf.basic.BasicBorders.MarginBorder;

/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    // 先水平轴翻转，再沿主对角线翻转。
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平轴翻转。
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n / 2; y++) {
                int temp = matrix[y][x];
                matrix[y][x] = matrix[n-y-1][x];
                matrix[n-y-1][x] = temp;
            }
        }
        // 主对角线翻转。
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < x; y++) {
                int temp = matrix[y][x];
                matrix[y][x] = matrix[x][y];
                matrix[x][y] = temp;
            }
        }
    }
}
// @lc code=end

