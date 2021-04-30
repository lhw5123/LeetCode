/*
 * @lc app=leetcode.cn id=46 lang=golang
 *
 * [46] 全排列
 */

// @lc code=start
// 思路：dfs
func permute(nums []int) [][]int {
	if len(nums) == 0 {
		return [][]int{}
	}

	used := make([]bool, len(nums))
	var p []int // 用来存放当前的一组解
	var ans [][]int
	dfs(nums, 0, p, &ans, &used)
	return ans
}

func dfs(nums []int, index int, p []int, ans *[][]int, used *[]bool) {
	if index == len(nums) {
		*ans = append(*ans, append([]int{}, p...))
		return
	}

	for i := 0; i < len(nums); i++ {
		if !(*used)[i] {
			(*used)[i] = true
			p = append(p, nums[i])
			dfs(nums, index+1, p, ans, used)
			(*used)[i] = false
			p = p[:len(p)-1]
		}
	}
}

// @lc code=end

