/*
 * @lc app=leetcode.cn id=215 lang=golang
 *
 * [215] 数组中的第K个最大元素
 */
// @lc code=start
// An IntHeap is a min-heap of ints.
import (
	"container/heap"
)

type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x interface{}) {
	// Push and Pop use pointer receivers because they modify the slice's length,
	// not just its contents.
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func findKthLargest(nums []int, k int) int {
	// min-heap of ints.
	h := &IntHeap{}
	heap.Init(h)
	for i := 0; i < k; i++ {
		heap.Push(h, nums[i])
	}

	for i := k; i < len(nums); i++ {
		if nums[i] < heap[len(heap)-1] {
			_ = heap.Pop(h)
			heap.Push(h, nums[i])
		}
	}

	return heap[0]
}

// @lc code=end