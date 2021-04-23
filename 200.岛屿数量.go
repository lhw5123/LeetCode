/*
 * @lc app=leetcode.cn id=200 lang=golang
 *
 * [200] 岛屿数量
 */

// @lc code=start
var dir = [4][2]int{
	{-1, 0},
	{0, 1},
	{1, 0},
	{0, -1},
}

func numIslands(grid [][]byte) int {
	m := len(grid)
	if m == 0 {
		return 0
	}

	n := len(grid[0])
	if n == 0 {
		return 0
	}

	res, visited := 0, make([][]bool, m)
	for i := 0; i < m; i++ {
		visited[i] = make([]bool, n)
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == '1' && !visited[i][j] {
				searchIslands(grid, &visited, i, j)
				res++
			}
		}
	}
	return res
}

// 从一个陆地开始向四周搜索将陆地标记为 visited。
func searchIslands(grid [][]byte, visited *[][]bool, x, y int) {
	(*visited)[x][y] = true
	for i := 0; i < 4; i++ {
		nx := x + dir[i][0]
		ny := y + dir[i][1]
		if isInBoard(grid, nx, ny) && !(*visited)[nx][ny] && grid[nx][ny] == '1' {
			searchIslands(grid, visited, nx, ny)
		}
	}
}

func isInBoard(grid [][]byte, x, y int) bool {
	m := len(grid)
	if x >= m {
		return false
	}

	n := len(grid[0])
	if y >= n {
		return false
	}

	if x >= 0 && x < m && y >= 0 && y < n {
		return true
	}
	return false
}

// @lc code=end

