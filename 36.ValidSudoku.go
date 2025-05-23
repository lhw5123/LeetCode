/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
*/

func isValidSudoku(board [][]byte) bool {
	var (
		rows  = make([]map[byte]bool, 9)
		cols  = make([]map[byte]bool, 9)
		boxes = make([]map[byte]bool, 9)
	)

	for i := 0; i < 9; i++ {
		rows[i] = make(map[byte]bool)
		cols[i] = make(map[byte]bool)
		boxes[i] = make(map[byte]bool)
	}

	for y := 0; y < 9; y++ {
		for x := 0; x < 9; x++ {
			num := board[y][x]
			if num == '.' {
				continue
			}

			boxIndex := (y/3)*3 + x/3 // boxIndex 表示是第几个矩阵
			/*
				    0 0 0 | 1 1 1 | 2 2 2
					0 0 0 | 1 1 1 | 2 2 2
					0 0 0 | 1 1 1 | 2 2 2
					---------------------
					3 3 3 | 4 4 4 | 5 5 5
					3 3 3 | 4 4 4 | 5 5 5
					3 3 3 | 4 4 4 | 5 5 5
					---------------------
					6 6 6 | 7 7 7 | 8 8 8
					6 6 6 | 7 7 7 | 8 8 8
					6 6 6 | 7 7 7 | 8 8 8
			*/

			if rows[y][num] || cols[x][num] || boxes[boxIndex][num] {
				return false
			}

			rows[y][num] = true
			cols[x][num] = true
			boxes[boxIndex][num] = true
		}
	}

	return true
}
