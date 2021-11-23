/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        int res = heights[0];
        int slow = 0, fast = 1;
        int n = heights.length;
        while (fast < n) {
            if (heights[fast] < heights[slow]) {
                slow = fast;
            } else {
                
            }
        }

        return res;
    }
}
// @lc code=end

