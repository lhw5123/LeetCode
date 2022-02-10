import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int n = rows * cols;
        int round = 0;
        while(res.size() < n) {
            int x = round, y = round;
            while (res.size() < n && x < cols - round) {
                res.add(matrix[y][x]);
                x++;
            }
            x--;
            y++;
            while (res.size() < n && y < rows - round) {
                res.add(matrix[y][x]);
                y++;
            }
            y--;
            x--;
            while (res.size() < n && x >= round) {
                res.add(matrix[y][x]);
                x--;
            }
            x++;
            y--;
            while (res.size() < n && y > round) {
                res.add(matrix[y][x]);
                y--;
            }
            round++;
        }

        return res;
    }
}
// @lc code=end

