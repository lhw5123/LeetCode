package com.hevin.string;

import java.util.ArrayList;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        ArrayList<Character> list = new ArrayList<>();
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                maxLen = Math.max(list.size(), maxLen);
                list.clear();
            }
            list.add(s.charAt(i));
        }
        return maxLen;
    }
}
