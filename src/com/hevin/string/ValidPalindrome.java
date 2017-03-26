package com.hevin.string;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * For example:
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int head = 0;
        int end = s.length() - 1;
        char cHead, cEnd;

        while (head < end) {
            cHead = s.charAt(head);
            cEnd = s.charAt(end);

            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cEnd)) {
                end--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cEnd)) {
                    return false;
                }
                head++;
                end--;
            }
        }
        return true;
    }
}
