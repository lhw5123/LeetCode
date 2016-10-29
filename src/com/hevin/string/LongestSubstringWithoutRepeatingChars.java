package com.hevin.string;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring
 */
public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        int lastIndices[] = new int[256];   // 存放字符串中每个字符所在的位置。
        for (int i = 0; i < 256; i++) {
            lastIndices[i] = -1;
        }

        int maxLen = 0;
        int curLen = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (lastIndices[cur] < start) { // 第一次遇到这个字符
                curLen++;
            } else {
                int lastIndex = lastIndices[cur];   // 当遇到相同的字符，记录下当前的位置。
                curLen = i - start;
                start = lastIndex + 1;
            }

            lastIndices[cur] = i;

            if (curLen > maxLen) {
                maxLen = curLen;
            }
        }

        return maxLen;
    }
}
