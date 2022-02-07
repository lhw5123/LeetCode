/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        // left: 最后一个不是 0 的位置
        // right: 正常的遍历指针
        int left = 0, right = 0;
        while (right < len) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
    }
}
// @lc code=end

