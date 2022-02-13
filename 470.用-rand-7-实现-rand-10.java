/*
 * @lc app=leetcode.cn id=470 lang=java
 *
 * [470] 用 Rand7() 实现 Rand10()
 * 也就是用 Rand7() 生成一个数字范围覆盖 10 的区间，再从中选出满足条件的数字。
 */

// @lc code=start
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        while (true) {
            int x = (rand7() - 1) * 7 + (rand7() - 1);  // 0 - 48
            if (x >= 1 && x <= 40) {
                return x % 10 + 1;
            }
        }
    }
}
// @lc code=end

