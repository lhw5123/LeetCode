/*
 * @lc app=leetcode.cn id=279 lang=golang
 *
 * [279] 完全平方数
 */

// @lc code=start
func numSquares(n int) int {
	queue := []int{n}
	visited := make([]bool, n+1) // 因为图中存在环，所以需要记录哪些结点访问过
	step := 1

	for len(queue) > 0 {
		size := len(queue)
		for i := 0; i < size; i++ {
			front := queue[0]
			queue = queue[1:]
			// 找到 <= 当前值的所有完全平方数
			for j := 1; j*j <= front; j++ {
				if j*j == front {
					return step
				}

				next := front - j*j
				if !visited[next] {
					queue = append(queue, next)
					visited[next] = true
				}
			}
		}

		step++
	}

	return 0
}

// @lc code=end

