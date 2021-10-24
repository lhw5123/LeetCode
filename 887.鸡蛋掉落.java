import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=887 lang=java
 *
 * [887] 鸡蛋掉落
 * 
 * // 「最坏」：穷尽了搜索区间
 * // 「至少」：扔鸡蛋的次数最少
 */

// @lc code=start
class Solution {
    private Map<String, Integer> memo = new HashMap<>();

    // k 个鸡蛋，n 层楼。
    public int superEggDrop(int k, int n) {
        return dp2(k, n);
    }

    // 最直观的动态规划解法，但某些 case 会超时。
    private int dp(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }

        String key = k + "-" + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            res = Math.min(res, Math.max(
                dp(k, n - i),   // 没有碎
                dp(k - 1, i - 1)    // 碎了
                ) + 1   // 表示在第 i 层扔了一次
             );
        }
        memo.put(key, res);

        return res;
    }

    // 换一种思路：dp[k][m] 表示 k 个鸡蛋，最多扔 m 次，可以找到的最高楼层数。
    private int dp2(int k, int n) {
        if (k == 1) {
            return n;
        }

        if (n == 0) {
            return 0;
        }

        // m 最多不会超过 n 次（线性扫描）
        int dp[][] = new int[k + 1][n + 1];
        int m = 0;
        while (dp[k][m] < n) {
            m++;
            for (int i = 1; i <= k; i++) {
                dp[i][m] = dp[i][m - 1] + dp[i - 1][m - 1] + 1;
            }
        }
        return m;
    }
}
// @lc code=end

