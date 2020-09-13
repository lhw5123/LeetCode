/*
 * @lc app=leetcode.cn id=79 lang=golang
 *
 * [79] 单词搜索
 */

// @lc code=start
var cols, rows int

func exist(board [][]byte, word string) bool {
	cols = len(board) // 有多少行
	if cols == 0 {
		return false
	}

	rows = len(board[0])

	marked := make([][]bool, cols)
	for i := 0; i < len(marked); i++ {
		marked[i] = make([]bool, rows)
	}

	for i, column := range board {
		for j := range column {
			if dfs(&board, &marked, i, j, 0, word) {
				return true
			}
		}
	}

	return false
}

var direction = [4][2]int{
	{-1, 0},
	{0, 1},
	{1, 0},
	{0, -1},
}

func dfs(board *[][]byte, marked *[][]bool, i, j, start int, word string) bool {
	if start == len(word)-1 {
		return (*board)[i][j] == word[start]
	}

	if (*board)[i][j] == word[start] {
		(*marked)[i][j] = true

		for _, d := range direction {
			newX := i + d[0]
			newY := j + d[1]
			if isArea(newX, newY) && !(*marked)[newX][newY] {
				if dfs(board, marked, newX, newY, start+1, word) {
					return true
				}
			}
		}

		(*marked)[i][j] = false
	}

	return false
}

func isArea(i, j int) bool {
	return 0 <= i && i < cols && 0 <= j && j < rows
}

// @lc code=end

