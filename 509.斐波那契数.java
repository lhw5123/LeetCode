/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
         
        int t1 = 1, t2 = 2;
        for (int i = 2; i < n; i++) {
            int tmp = t1 + t2;
            t1 = t2;
            t2 = tmp;
        }
        return t1;
    }
}
// @lc code=end

