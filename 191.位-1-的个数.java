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
        
        while (tmp != 0) {
            tmp = tmp & (tmp - 1);
            count++;
        }

        return count;
    }
}
// @lc code=end

