/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        int l = 1, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid > x / mid) {
                r = mid - 1;
            } else if (mid < x / mid) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return r;
    }

    // 变形题：小数点精确到 xxx
    public float mySqrt2(int c) {
        double e = 1e-3;    // 精确到 3 位小数。
        double x = c;
        double y = (x + c / x) / 2;
        while (Math.abs(x - y) > e) {
            x = y;
            y = (x + c / x) / 2;
        }
        return (float) x;
    }
}
// @lc code=end

