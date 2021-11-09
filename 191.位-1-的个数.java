/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int tmp = n;
        int count = 0;

        // solution 1
        while (tmp != 0) {
            tmp = tmp & (tmp - 1);
            count++;
        }

        // solution 2
        // while (tmp != 0) {
        //     if ((tmp & 1) == 1) {
        //         count++;
        //     }
        //     tmp = tmp >>> 1;
        // }

        return count;
    }
}
// @lc code=end

