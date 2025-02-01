import "sort"

// Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
//
// According to the definition of h-index on Wikipedia:
// The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

func hIndex(citations []int) int {
	sort.Ints(citations)

	n := len(citations)
	left, right := 0, n-1

	// 二分查找
	for left <= right {
		mid := left + (right-left)/2
		h := n - mid
		if citations[mid] >= h {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}

	return n - left
}

