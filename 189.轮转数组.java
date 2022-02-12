/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */

// @lc code=start
class Solution {
    // 翻转数组
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k == 0 || k == len) {
            return;
        }

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    // 冒泡（会超时）
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k == 0 || k == len) {
            return;
        }

        int start = 0;
        for (int i = len - k; i < len; i++) {
            for (int j = i; j > start; j--) {
                swap(nums, j, j - 1);
            }
            start++;
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

