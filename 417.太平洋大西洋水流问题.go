/*
 * @lc app=leetcode.cn id=417 lang=golang
 *
 * [417] 太平洋大西洋水流问题
 */

// @lc code=start
func pacificAtlantic(heights [][]int) [][]int {
	rows := len(heights)
	cols := len(heights[0])

	res := [][]int{}
	for i := 0; i < rows; i++ {
		for j := 0; j < cols; j++ {
			if bfs(heights, i, j, rows, cols) {
				res = append(res, []int{i, j})
			}
		}
	}
	return res
}

func bfs(heights [][]int, i, j, rows, cols int) bool {
	index := getIndex(i, j, cols)

	var queue []int
	queue = append(queue, index)

	couldArriveAtlantic := false
	couldArrivePacific := false

	visited := make([]bool, rows*cols)
	visited[index] = true

	for len(queue) > 0 {
		front := queue[0]
		queue = queue[1:]
		curX := front / cols
		curY := front % cols

		if !couldArrivePacific && arrivePacific(curX, curY, rows, cols) {
			couldArrivePacific = true
		}
		if !couldArriveAtlantic && arriveAtlantic(curX, curY, rows, cols) {
			couldArriveAtlantic = true
		}
		if couldArriveAtlantic && couldArrivePacific {
			return true
		}

		for _, direction := range directions {
			// if couldArrivePacific && i < 2 {
			// 	continue
			// }
			// if couldArriveAtlantic && i >= 2 {
			// 	continue
			// }
			newX := curX + direction[0]
			newY := curY + direction[1]
			newIndex := getIndex(newX, newY, cols)
			if inArea(newX, newY, rows, cols) && heights[newX][newY] <= heights[curX][curY] && !visited[newIndex] {
				queue = append(queue, newIndex)
				visited[newIndex] = true
			}
		}
	}

	return false
}

var directions = [][]int{
	{-1, 0},
	{0, -1},
	{1, 0},
	{0, 1},
}

func arrivePacific(i, j, rows, cols int) bool {
	return i == 0 || j == 0
}

func arriveAtlantic(i, j, rows, cols int) bool {
	return i == cols-1 || j == rows-1
}

func getIndex(x, y, cols int) int {
	return x*cols + y
}

func inArea(x, y, rows, cols int) bool {
	return x >= 0 && x < rows && y >= 0 && y < cols
}

// @lc code=end

