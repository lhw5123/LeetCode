/*
 * @lc app=leetcode.cn id=67 lang=cpp
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
public:
    string addBinary(string a, string b) {
        int carry = 0;
        int i = (int)a.size() - 1;
        int j = (int)b.size() - 1;
        string result;
        while (i >= 0 || j >= 0 || carry != 0)
        {
            int m;
            if (i >= 0)
            {
                m = a[i--] - '0';
            }
            else
            {
                m = 0;
            }
            int n;
            if (j >= 0)
            {
                n = b[j--] - '0';
            }
            else
            {
                n = 0;
            }
            int sum = m + n + carry;
            result += to_string(sum % 2);
            carry = sum / 2;
        }
        reverse(result.begin(), result.end());
        return result;
    }
};
// @lc code=end

