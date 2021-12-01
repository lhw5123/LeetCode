/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || num1 == "0") {
            return num2;
        }
        if (len2 == 0 || num2 == "0") {
            return num1;
        }

        StringBuilder res = new StringBuilder();
        int carry = 0;
        int l1 = len1 - 1;
        int l2 = len2 - 1;
        while (l1 >= 0 || l2 >= 0) {
            int digit1 = 0;
            int digit2 = 0;
            if (l1 >= 0) {
                digit1 = char2num(num1.charAt(l1));
                l1--;
            }
            if (l2 >= 0) {
                digit2 = char2num(num2.charAt(l2));
                l2--;
            }
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            res.append(sum % 10);
        }
        if (carry != 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }

    private int char2num(char c) {
        return c - '0';
    }
}
// @lc code=end

