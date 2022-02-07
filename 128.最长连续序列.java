import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 
 * 以下两种解法没有绝对的高低之分。
 */

// @lc code=start
class Solution {
    // 时间复杂度：O(nlogn) 空间复杂度：O(1)
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        Arrays.sort(nums);
        int ans = 1;
        int curLen = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i - 1] + 1 == nums[i]) {
                curLen++;
            } else {
                curLen = 1;
            }
            ans = Math.max(ans, curLen);
        }
        return ans;
    }

    // 时间复杂度：O(n) 空间复杂度：O(n)
    public int longestConsecutive2(int[] nums) {
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

