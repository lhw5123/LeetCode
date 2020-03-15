/*
 * @lc app=leetcode.cn id=217 lang=javascript
 *
 * [217] 存在重复元素
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
  let map = new Map() // <元素，出现次数>
  for (element of nums) {
    if (!map.has(element)) {
      map.set(element, 1)
    } else {
      let counts = map.get(element)
      if (counts + 1 > 1) {
        return true
      } else {
        map.set(element, counts + 1)
      }
    }
  }
  return false
};
// @lc code=end

