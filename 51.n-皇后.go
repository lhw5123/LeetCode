/*
 * @lc app=leetcode.cn id=51 lang=golang
 *
 * [51] N 皇后
 */

// @lc code=start
func solveNQueens(n int) [][]string {
	if n == 0 {
		return [][]string{}
	}

	// 记录某一列是否放置了皇后
	col := make([]bool, n)
	// 记录主对角线上的单元格是否放置了皇后
	main := make([]bool, 2*n-1)
	// 记录副对角线上的单元格是否放置了皇后
	sub := make([]bool, 2*n-1)
	var path []int
	var ans [][]string
	dfs(n, 0, &col, &main, &sub, path, &ans)
	return ans
}

func dfs(n, row int, col, main, sub *[]bool, path []int, ans *[][]string) {
	if row == n {
		board := covert2board(n, path)
		*ans = append(*ans, board)
		return
	}

	// 判断 row 行的每一列尝试能否放置
	for i := 0; i < n; i++ {
		if !(*col)[i] && !(*main)[row-i+n-1] && !(*sub)[row+i] {
			path = append(path, i)
			(*col)[i] = true
			(*main)[row-i+n-1] = true
			(*sub)[row+i] = true
			dfs(n, row+1, col, main, sub, path, ans)

			(*sub)[row+i] = false
			(*main)[row-i+n-1] = false
			(*col)[i] = false
			path = path[:len(path)-1]
		}
	}
}

func covert2board(n int, path []int) []string {
	var board []string
	for _, num := range path {
		row := ""
		for i := 0; i < n; i++ {
			if i == num {
				row += "Q"
			} else {
				row += "."
			}
		}
		board = append(board, row)
	}
	return board
}

// @lc code=end

