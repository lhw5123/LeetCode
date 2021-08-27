/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    private int[][] directions = new int[][] {
        {-1, 0},
        {0, -1},
        {1, 0},
        {0, 1},
    };

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        int[][] visited = new int[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (grid[y][x] == '1' && visited[y][x] == 0) {
                    searchIslands(grid, visited, x, y);
                    res++;
                }
            }
        }
        return res;
    }

    // Note: 连成一片的算一个岛。
    private void searchIslands(char[][] grid, int[][] visited, int x, int y) {
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];
            if (inBoard(grid, nx, ny) && visited[ny][nx] == 0 && grid[ny][nx] == '1') {
                searchIslands(grid, visited, nx, ny);
            }
        }
    }

    private boolean inBoard(char[][] grid, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length;
        return 0 <= x && x < cols && 0 <= y && y < rows;
    }
}
// @lc code=end

