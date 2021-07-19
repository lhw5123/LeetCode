/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    // Binary search
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                int lp = mid;
                int rp = mid;
                while (lp >= 0 && nums[lp] == target) {
                    lp--;
                }
                res[0] = lp + 1;
                while (rp < n && nums[rp] == target) {
                    rp++;
                }
                res[1] = rp - 1;
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
// @lc code=end

