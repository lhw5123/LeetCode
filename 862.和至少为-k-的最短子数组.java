import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=862 lang=java
 *
 * [862] 和至少为 K 的最短子数组
 *
 * https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/description/
 *
 * algorithms
 * Hard (21.48%)
 * Likes:    416
 * Dislikes: 0
 * Total Accepted:    24.1K
 * Total Submissions: 111.2K
 * Testcase Example:  '[1]\n1'
 *
 * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组
 * ，返回 -1 。
 * 
 * 子数组 是数组中 连续 的一部分。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1], k = 1
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2], k = 4
 * 输出：-1
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [2,-1,2], k = 3
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^5 <= nums[i] <= 10^5
 * 1 <= k <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;
        long[] p = new long[len+1];
        int res = len + 1;
        for (int i = 0; i < len; i++) {
            p[i+1] = p[i] + (long) nums[i];
        }

        Deque<Integer> monoq = new LinkedList<>();
        for (int y = 0; y < p.length; y++) {
            while (!monoq.isEmpty() && p[y] <= p[monoq.getLast()]) {
                monoq.removeLast();
            }
            while (!monoq.isEmpty() && p[y] >= p[monoq.getFirst()] + k) {
                res = Math.min(res, y - monoq.removeFirst());
            }
            monoq.addLast(y);
        }

        return res < len + 1 ? res : -1;
    }
}
// @lc code=end

