import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int res = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int curNum = num;
                int curStreak = 1;

                while (numSet.contains(curNum+1)) {
                    curNum++;
                    curStreak++;
                }
                res = Math.max(res, curStreak);
            }
        }

        return res;
    }
}
// @lc code=end

