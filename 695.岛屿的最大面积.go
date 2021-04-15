/*
 * @lc app=leetcode.cn id=695 lang=golang
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
// BFS
func maxAreaOfIsland(grid [][]int) int {
	rows := len(grid)
	cols := len(grid[0])
	visited := make([]bool, rows*cols)

	maxArea := 0
	for i := 0; i < rows; i++ {
		for j := 0; j < cols; j++ {
			if grid[i][j] == 1 && !visited[getIndex(i, j, cols)] {
				maxArea = max(maxArea, bfs(grid, i, j, rows, cols, visited))
			}
		}
	}
	return maxArea
}

func bfs(grid [][]int, i, j, rows, cols int, visited []bool) int {
	count := 0
	queue := []int{}
	index := getIndex(i, j, cols)
	queue = append(queue, index)
	visited[index] = true

	for len(queue) > 0 {
		front := queue[0]
		queue = queue[1:]
		curX := front / cols
		curY := front % cols
		count++
		for _, direction := range directions {
			newX := curX + direction[0]
			newY := curY + direction[1]
			newIndex := getIndex(newX, newY, cols)
			if inArea(newX, newY, rows, cols) && grid[newX][newY] == 1 && !visited[newIndex] {
				queue = append(queue, newIndex)
				visited[newIndex] = true
			}
		}
	}

	return count
}

var directions = [][]int{
	{-1, 0},
	{0, -1},
	{1, 0},
	{0, 1},
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func getIndex(x, y, cols int) int {
	return x*cols + y
}

func inArea(i, j, rows, cols int) bool {
	return i >= 0 && i < rows && j >= 0 && j < cols
}

// @lc code=end

