import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果 Hard
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        // 分为从左往右和从右往左分开处理
        int len = ratings.length;
        int[] left = new int[len];
        Arrays.fill(left, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        int[] right = new int[len];
        Arrays.fill(right, 1);
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }

    // 时间复杂度 O(n) 空间复杂度 O(1)
    // 但不容易想到和写对，因此只作为上面方法的一种补充
    private int candy2(int[] ratings) {
        int n = ratings.length;
        int res = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                res += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                res += dec;
                pre = 1;    // pre 表示的其实是当前位置所需要的糖果数。
            }
        }
        return res;
    }
}
// @lc code=end

