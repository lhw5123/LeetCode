package com.hevin.string;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * <p>
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowels {
    static final String vowels = "aeiouAEIOU";

    public String reverseVowels(String s) {
        int first = 0, last = s.length() - 1;
        char[] array = s.toCharArray();
        while (first < last) {
            while (first < last && vowels.indexOf(array[first]) == -1) {
                first++;
            }
            while (first < last && vowels.indexOf(array[last]) == -1) {
                last--;
            }
            char tmp = array[first];
            array[first] = array[last];
            array[last] = tmp;
            first++;
            last--;
        }
        return new String(array);
    }
}
