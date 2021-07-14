/*
 * @lc app=leetcode.cn id=39 lang=golang
 *
 * [39] 组合总和
 */

// @lc code=start
func combinationSum(candidates []int, target int) [][]int {
	var res [][]int
	var path []int
	dfs(candidates, 0, len(candidates), target, path, &res)
	return res
}

func dfs(candidates []int, begin, length, target int, path []int, res *[][]int) {
	if target < 0 {
		return
	}

	if target == 0 {
		*res = append(*res, append([]int{}, path...))
		return
	}

	for i := begin; i < length; i++ {
		path = append(path, candidates[i])
		// Note：因为允许一个数字被重复选择，所以这里的 begin 依旧是自己（i）。
		dfs(candidates, i, length, target-candidates[i], path, res)
		path = path[:len(path)-1]
	}
}

// @lc code=end

