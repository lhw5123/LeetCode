import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=645 lang=java
 *
 * [645] 错误的集合
 */

// @lc code=start
class Solution {
    public int[] findErrorNums(int[] nums) {
        return new int[]{
            Arrays.stream(nums).sum() - Arrays.stream(nums).distinct().sum(),
            (1 + nums.length) * nums.length / 2 - Arrays.stream(nums).distinct().sum()
        };
    }
}
// @lc code=end

