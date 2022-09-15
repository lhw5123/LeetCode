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
			if dfs(board, word, y, x, 0, &visited) {
				return true
			}
		}
	}
	return false
}

func dfs(board [][]byte, word string, y, x, index int, visited *[]bool) bool {
	if index == len(word)-1 {
		return board[y][x] == word[index]
	}

	if board[y][x] == word[index] {
		rows := len(board)
		cols := len(board[0])
		(*visited)[getIndex(y, x, rows)] = true
		for _, d := range dir {
			ny := y + d[0]
			nx := x + d[1]
			if inArea(ny, nx, rows, cols) && !(*visited)[getIndex(ny, nx, rows)] {
				if dfs(board, word, ny, nx, index+1, visited) {
					return true
				}
			}
		}
		(*visited)[getIndex(y, x, rows)] = false
	}
	return false
}

var dir = [][]int{
	[]int{0, 1}, // [y, x]
	[]int{0, -1},
	[]int{1, 0},
	[]int{-1, 0},
}

func inArea(y, x, rows, cols int) bool {
	return y >= 0 && y < rows && x >= 0 && x < cols
}

func getIndex(y, x, rows int) int {
	return x*rows + y
}
