package com.hevin.string;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting
 * from the first of the string.
 * If there are less than k characters left, reverse all of them. If there are less than 2k but greater
 * than or equal to k characters, then reverse the first k characters and left the other as original.
 * <p>
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * <p>
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class ReverseString2 {
    // 关键点在于 k 值的计算
    public String reverseStr(String s, int k) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        char[] charArr = s.toCharArray();

        if (k > charArr.length) {
            reverse(charArr, 0, charArr.length - 1);
        } else {
            int i = 0;
            int first;
            int last;

            while (i * 2 * k < charArr.length) {
                first = i * 2 * k;
                if (first + k > charArr.length) {
                    last = charArr.length;
                } else {
                    last = first + k;
                }
                reverse(charArr, first, last);
                i++;
            }
        }
        return new String(charArr);
    }

    private void reverse(char[] charArr, int first, int last) {
        while (first < last) {
            char buf = charArr[first];
            charArr[first] = charArr[last];
            charArr[last] = buf;
            first++;
            last--;
        }
    }
}
