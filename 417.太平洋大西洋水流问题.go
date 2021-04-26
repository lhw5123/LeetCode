/*
 * @lc app=leetcode.cn id=417 lang=golang
 *
 * [417] 太平洋大西洋水流问题
 */

// @lc code=start
// 从四边出发做 bfs，最后对两个 visited 数据求交集，得到可以同时到达 Pacific 和 Atlantic 的位置。
func pacificAtlantic(heights [][]int) [][]int {
	rows := len(heights)
	cols := len(heights[0])

	var qp, qa []int
	vp := make([]bool, rows*cols)
	va := make([]bool, rows*cols)

	for y := 0; y < rows; y++ {
		qp = append(qp, getIndex(0, y, cols))      // left
		qa = append(qa, getIndex(cols-1, y, cols)) // right
	}

	for x := 0; x < cols; x++ {
		qp = append(qp, getIndex(x, 0, cols))      // top
		qa = append(qa, getIndex(x, rows-1, cols)) // bottom
	}

	bfs(heights, &qp, &vp, rows, cols)
	bfs(heights, &qa, &va, rows, cols)

	res := [][]int{}
	for y := 0; y < rows; y++ {
		for x := 0; x < cols; x++ {
			index := getIndex(x, y, cols)
			if vp[index] && va[index] {
				res = append(res, []int{y, x})
			}
		}
	}

	return res
}

func bfs(heights [][]int, q *[]int, v *[]bool, rows, cols int) {
	for len(*q) > 0 {
		front := (*q)[0]
		*q = (*q)[1:]
		if (*v)[front] {
			continue
		}

		x := front % cols
		y := front / cols
		h := heights[y][x]
		(*v)[front] = true

		for _, dir := range directions {
			newX := x + dir[0]
			newY := y + dir[1]
			newIndex := getIndex(newX, newY, cols)
			if inArea(newX, newY, rows, cols) && heights[newY][newX] >= h && !(*v)[newIndex] {
				*q = append(*q, newIndex)
			}
		}
	}
}

var directions = [][]int{
	{-1, 0},
	{0, -1},
	{1, 0},
	{0, 1},
}

func getIndex(x, y, cols int) int {
	return y*cols + x
}

func inArea(x, y, rows, cols int) bool {
	return x >= 0 && x < cols && y >= 0 && y < rows
}

// @lc code=end

