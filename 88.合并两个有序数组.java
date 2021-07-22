/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        } else {
            int p = m - 1, q = n - 1;
            while (p >= 0 && q >= 0) {
                if (nums2[q] >= nums1[p]) {
                    nums1[p + q + 1] = nums2[q];
                    q--;
                } else {
                    nums1[p + q + 1] = nums1[p];
                    p--;
                }
            }
            while (q >= 0) {
                nums1[q] = nums2[q];
                q--;
            }
        }
    }
}
// @lc code=end

