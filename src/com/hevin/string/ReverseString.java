package com.hevin.string;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString {
    public static String reverseString(String s) {
        char[] result = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        char buf;
        while (left <= right) {
            buf = result[left];
            result[left] = result[right];
            result[right] = buf;
            left++;
            right--;
        }

        return new String(result);
    }
}
