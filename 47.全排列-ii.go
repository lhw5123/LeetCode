/*
 * @lc app=leetcode.cn id=47 lang=golang
 *
 * [47] 全排列 II
 */

// @lc code=start
func permuteUnique(nums []int) [][]int {
	length := len(nums)
	var res [][]int
	if length == 0 {
		return res
	}

	// 排序是为了剪枝
	sort.Ints(nums)
	used := make([]bool, length)
	var path []int
	dfs(nums, path, 0, length, &used, &res)
	return res
}

// @index: 当前排列到第几个数字。如果到最后了，就表示得到了一组解。
func dfs(nums []int, path []int, index, length int, used *[]bool, res *[][]int) {
	if index == length {
		*res = append(*res, append([]int{}, path...))
		return
	}

	for i := 0; i < length; i++ {
		if (*used)[i] {
			continue
		}

		// i > 0 是为了保证 [i-1] 有意义
		// !(*used)[i-1] 是因为 dfs 之后会做逆操作
		if i > 0 && nums[i] == nums[i-1] && !(*used)[i-1] {
			continue
		}

		(*used)[i] = true
		path = append(path, nums[i])
		dfs(nums, path, index+1, length, used, res)
		path = path[:len(path)-1]
		(*used)[i] = false
	}
}

// @lc code=end

