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

	res := [][]int{}
	used := make([]bool, len(nums))
	p := []int{}
	genPermutation(nums, 0, p, &res, &used)
	return res
}

func genPermutation(nums []int, index int, p []int, res *[][]int, used *[]bool) {
	if index == len(nums) {
		temp := make([]int, len(p))
		copy(temp, p)
		*res = append(*res, temp)
		return
	}

	for i := 0; i < len(nums); i++ {
		if !(*used)[i] {
			(*used)[i] = true
			p = append(p, nums[i])
			genPermutation(nums, index+1, p, res, used)
			p = p[:len(p)-1] // 去掉 p 中的最后一个元素
			(*used)[i] = false
		}
	}
	return
}

// @lc code=end

