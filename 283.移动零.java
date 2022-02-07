/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 * 将数组中的所有 0 移动到尾端。
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        // l 指向最后一个为 0 的元素
        int l = 0, r = 0;
        while (r < len) {
            if (nums[r] != 0) {
                swap(nums, l, r);
                l++;
            }
            r++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

