// https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked

func setZeroes(matrix [][]int) {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return
	}

	var (
		firstRowExistZero bool
		firstColExistZero bool
		rows              = len(matrix)
		cols              = len(matrix[0])
	)

	for y := 0; y < rows; y++ {
		if matrix[y][0] == 0 {
			firstColExistZero = true
			break
		}
	}
	for x := 0; x < cols; x++ {
		if matrix[0][x] == 0 {
			firstRowExistZero = true
			break
		}
	}

	// Use first row and column as flag fields.
	for y := 0; y < rows; y++ {
		for x := 0; x < cols; x++ {
			if matrix[y][x] == 0 {
				matrix[y][0] = 0
				matrix[0][x] = 0
			}
		}
	}

	// handle [1:] rows and columns
	for y := 1; y < rows; y++ {
		if matrix[y][0] == 0 {
			for x := 1; x < cols; x++ {
				matrix[y][x] = 0
			}
		}
	}
	for x := 1; x < cols; x++ {
		if matrix[0][x] == 0 {
			for y := 1; y < rows; y++ {
				matrix[y][x] = 0
			}
		}
	}

	if firstColExistZero {
		for y := 0; y < rows; y++ {
			matrix[y][0] = 0
		}
	}
	if firstRowExistZero {
		for x := 0; x < cols; x++ {
			matrix[0][x] = 0
		}
	}
}
