package com.hevin.string;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting
 * from the start of the string.
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
    public String reverseStr(String s, int k) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        
    }
}
