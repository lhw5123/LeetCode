/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int lv = numbers[l], rv = numbers[r];
            if (numbers[l] + numbers[r] < target) {
                while (l < r && numbers[l] == lv) {
                    l++;
                }
            } else if (numbers[l] + numbers[r] > target) {
                while (l < r && numbers[r] == rv) {
                    r--;
                }
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
// @lc code=end

