package com.hevin.array;

/**
 * 检查括号是否正确
 */
public class CheckBrackets {
    public boolean checkBrackets(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == '(') {
                count++;
            } else {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
