import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        // i 对应的是乘数，j 对应的是被乘数。
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 一位数和一位数相乘，结果最多只能是两位。
                // 然后对应到结果数组中的位置，就是 i + j 和 i + j + 1。
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        // 前面可能有 0
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }

        StringBuilder str = new StringBuilder();
        for (; i < res.length; i++) {
            str.append(res[i]);
        }
        return str.length() == 0 ? "0" : str.toString();
    }
}
// @lc code=end

