import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        int[] ans = new int[rows * cols];
        int k = 0;
        // 从第一行开始到最后一列，每一个元素都延左对角线遍历。
        for (int i = 0; i < rows + cols - 1; i++) {
            int x = i < cols ? i : cols - 1;
            int y = i < cols ? 0 : i - cols + 1;

            List<Integer> line = new ArrayList<>();
            while (x >= 0 && y < rows) {
                line.add(mat[y][x]);
                x--;
                y++;
            }

            if (i % 2 == 0) {
                Collections.reverse(line);
            }
            for (int j = 0; j < line.size(); j++) {
                ans[k] = line.get(j);
                k++;
            }
        }
        return ans;
    }
}
// @lc code=end

