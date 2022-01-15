/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 * 无论旋转多少次，最多只会有两段有序序列。
 * 要求必须用二分查找。
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        if (nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

