/*
 * @lc app=leetcode.cn id=56 lang=golang
 *
 * [56] 合并区间
 */

// @lc code=start
func merge(intervals [][]int) [][]int {
	if len(intervals) == 0 {
		return intervals
	}

	quickSort(intervals, 0, len(intervals)-1)
	merged := make([][]int, 0)
	for _, item := range intervals {
		L := item[0]
		R := item[1]
		if len(merged) == 0 || merged[len(merged)-1][1] < L {
			merged = append(merged, item)
		} else {
			merged[len(merged)-1][1] = max(merged[len(merged)-1][1], R)
		}
	}

	return merged
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func partation(a [][]int, low, high int) int {
	pivot := a[high]
	i := low
	for j := low; j < high; j++ {
		start := a[j][0]
		end := a[j][1]
		if start < pivot[0] || (start == pivot[0] && end < pivot[1]) {
			a[j], a[i] = a[i], a[j]
			i++
		}
	}
	a[i], a[high] = a[high], a[i]
	return i
}

func quickSort(a [][]int, low, high int) {
	if low > high {
		return
	}

	p := partation(a, low, high)
	quickSort(a, low, p-1)
	quickSort(a, p+1, high)
}

