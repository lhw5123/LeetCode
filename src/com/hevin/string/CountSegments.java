package com.hevin.string;

/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence
 * of non-space characters.
 * <p>
 * Please note that the string does not contain any non-printable characters.
 * <p>
 * Example:
 * Input: "Hello, my name is John" Output: 5
 */
public class CountSegments {

    public static int countSegments(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) { // 统计每一段的第一个字母
                result++;
            }
        }
        return result;
    }
}
