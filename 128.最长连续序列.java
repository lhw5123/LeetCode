import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
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
            // 如果 numSet 中包含 num-1，那就意味着 num 已经在 num-1 那一次中被计算过了。
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

