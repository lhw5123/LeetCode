/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int x, int y) {
        int rows = 9, cols = 9;
        // 遍历到了最后一列，前进到下一行的开头。
        if (x == cols) {
            return backtrack(board, 0, y + 1);
        }
        // 找到了一组解。
        if (y == rows) {
            return true;
        }
        // 已经有预设数字了，不需要我们穷举。
        if (board[y][x] != '.') {
            return backtrack(board, x + 1, y);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            if (!isValid(board, x, y, ch)) {
                continue;
            }
            board[y][x] = ch;
            if (backtrack(board, x + 1, y)) {
                return true;
            }
            board[y][x] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int x, int y, char n) {
        for (int i = 0; i < 9; i++) {
            if (board[y][i] == n) {
                return false;
            }
            if (board[i][x] == n) {
                return false;
            }
            // 判断3*3的区域中有没有重复数字。
            if (board[(y / 3) * 3 + i / 3][(x / 3) * 3 + i % 3] == n) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

