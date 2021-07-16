/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        int p = 0, q = nums.length - 1;
        for (int i = 0; i <= q; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[p];
                nums[p] = 0;
                p++;
            }
            if (nums[i] == 2) {
                nums[i] = nums[q];
                nums[q] = 2;
                q--;
                if (nums[i] != 1) {
                    i--;
                }
            }
        }
    }
}
// @lc code=end

