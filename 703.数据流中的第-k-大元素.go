import (
	"container/heap"
	"sort"
)

/*
 * @lc app=leetcode.cn id=703 lang=golang
 *
 * [703] 数据流中的第 K 大元素
 */

// @lc code=start
// 思路：优先级队列（用堆实现）
type KthLargest struct {
	sort.IntSlice
	k int
}

func Constructor(k int, nums []int) KthLargest {
	kl := KthLargest{
		k: k,
	}
	for _, val := range nums {
		kl.Add(val)
	}
	return kl
}

func (this *KthLargest) Add(val int) int {
	heap.Push(this, val)
	if this.Len() > this.k {
		heap.Pop(this)
	}
	return this.IntSlice[0]
}

// 实现 Pop 和 Push 就表示了这是一个 heap
func (this *KthLargest) Pop() interface{} {
	a := this.IntSlice
	v := a[len(a)-1]
	this.IntSlice = a[:len(a)-1]
	return v
}

func (this *KthLargest) Push(v interface{}) {
	this.IntSlice = append(this.IntSlice, v.(int))
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * obj := Constructor(k, nums);
 * param_1 := obj.Add(val);
 */
// @lc code=end

