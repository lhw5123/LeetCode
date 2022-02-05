/*
 * @lc app=leetcode.cn id=845 lang=java
 *
 * [845] 数组中的最长山脉
 */

// @lc code=start
class Solution {
    public int longestMountain(int[] arr) {
        int ans = 0;
        int end = 0;
        int len = arr.length;
        while (end < len) {
            int start = end;
            while (end + 1 < len && arr[end] < arr[end + 1]) {
                // 向上爬，寻找峰值
                end++;
            }
            int peak = end; // 记下峰值的位置
            while (end + 1 < len && arr[end] > arr[end + 1]) {
                // 向下走，寻找谷底
                end++;
            }
            if (start < peak && peak < end) {
                ans = Math.max(ans, end - start + 1);
            }
            // 如果是平坡，将指针向前移动一步，防止死循环
            if (start == end) {
                end++;
            }
        }
        return ans;
    }
}
// @lc code=end

