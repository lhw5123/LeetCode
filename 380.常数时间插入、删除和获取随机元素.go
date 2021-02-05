/*
 * @lc app=leetcode.cn id=380 lang=golang
 *
 * [380] 常数时间插入、删除和获取随机元素
 */

// @lc code=start
type RandomizedSet struct {
	nums       []int
	valToIndex map[int]int
}

/** Initialize your data structure here. */
func Constructor() RandomizedSet {
	return RandomizedSet() {
		nums: make([]int, 0),
		valToIndex: make(map[int]int, 0),
	}
}

/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
func (s *RandomizedSet) Insert(val int) bool {
	if _, ok := s.valToIndex[val]; ok {
		return false
	}

	s.valToIndex[val] = len(s.nums)
	s.nums = append(s.nums, val)
	return true
}

/** Removes a value from the set. Returns true if the set contained the specified element. */
func (s *RandomizedSet) Remove(val int) bool {
	if _, ok := s.valToIndex[val]; !ok {
		return false
	}

	valIndex := s.valToIndex[val]
	s.valToIndex[s.nums[len(s.nums) - 1]] = valIndex

	// swap `val` and last item in nums.
	tmp := s.nums[len(s.nums) - 1]
	s.nums[len(s.nums) - 1] = s.nums[valIndex]
	s.nums[valIndex] = tmp

	// remove last element
	s.nums = s.nums[:len(s.nums) - 1]
	delete(s.valToIndex, valIndex)

	return true
}

/** Get a random element from the set. */
func (s *RandomizedSet) GetRandom() int {
	r := rand.Seed(time.Now().Unix())
	return nums[r.Int()%len(nums)]
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Insert(val);
 * param_2 := obj.Remove(val);
 * param_3 := obj.GetRandom();
 */
// @lc code=end

