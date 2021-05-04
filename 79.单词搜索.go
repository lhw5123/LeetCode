/*
 * @lc app=leetcode.cn id=79 lang=golang
 *
 * [79] 单词搜索
 */

// @lc code=start
func exist(board [][]byte, word string) bool {
	rows := len(board)
	if rows == 0 {
		return false
	}

	cols := len(board[0])
	visited := make([]bool, rows*cols)

	for x := 0; x < cols; x++ {
		for y := 0; y < rows; y++ {
			if dfs(board, word, x, y, 0, rows, cols, &visited) {
				return true
			}
		}
	}

	return false
}

func dfs(board [][]byte, word string, x, y, start, rows, cols int, visited *[]bool) bool {
	if start == len(word)-1 {
		return board[y][x] == word[start]
	}

	if board[y][x] == word[start] {
		index := getIndex(x, y, cols)
		(*visited)[index] = true
		for _, d := range directions {
			newX := x + d[0]
			newY := y + d[1]
			newIndex := getIndex(newX, newY, cols)
			if inArea(newX, newY, rows, cols) && !(*visited)[newIndex] {
				if dfs(board, word, newX, newY, start+1, rows, cols, visited) {
					return true
				}
			}
		}
		(*visited)[index] = false
	}

	return false
}

var directions = [][]int{
	{-1, 0},
	{0, -1},
	{1, 0},
	{0, 1},
}

func inArea(x, y, rows, cols int) bool {
	return x >= 0 && x < cols && y >= 0 && y < rows
}

func getIndex(x, y, cols int) int {
	return y*cols + x
}
