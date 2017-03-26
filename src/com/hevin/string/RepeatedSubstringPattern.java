package com.hevin.string;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * <p>
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explation: It's the substring "ab" twice
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int subLen = len / 2; subLen >= 1; subLen--) {    // subLen: ；当 len 为素数时，subLen == 1。
            if (len % subLen != 0) {
                continue;
            }
            int subCount = len / subLen; // 子串的个数
            String subStr = s.substring(0, subLen);

            int index;
            for (index = 1; index < subCount; index++) {
                if (!subStr.equals(s.substring(index * subLen, index * subLen + subLen))) {
                    break;
                }
            }
            if (index == subCount) {
                return true;
            }
        }
        return false;
    }
}
