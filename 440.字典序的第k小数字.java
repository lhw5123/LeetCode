import javax.print.event.PrintEvent;

import jdk.internal.agent.resources.agent;

/*
 * @lc app=leetcode.cn id=440 lang=java
 *
 * [440] 字典序的第K小数字
 */

// @lc code=start
class Solution {
    public int findKthNumber(int n, int k) {
        int p = 1;
        long prefix = 1;
        while (p < k) {
            int count = getCount(prefix, n);    // 获取当前前缀下有多少个数。
            if (p + count > k) {    // 第 k 个数在当前的前缀下。
                prefix *= 10;   // 因为在字典序下，数字 a 的下一个数字应该是 a*10。
                p++;
            } else {
                prefix++;
                p += count; // 将指针指向下一个前缀的起点。
            }
        }
        return (int) prefix;
    }

    // 获取前缀为 prefix 下的所有数字个数。
    // 用下一个前缀减去当前前缀起始值就得到了数字。
    // n: 数字的最大值。
    private int getCount(long prefix, int n) {
        int count = 0;
        for (long cur = prefix, next = prefix+1; cur <= n; cur *= 10, next *= 10) {
            count += Math.min(next, n+1) - cur;
        }
        return count;
    }
}
// @lc code=end

