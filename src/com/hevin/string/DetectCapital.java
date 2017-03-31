package com.hevin.string;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        char[] chars = word.toCharArray();
        boolean firstIsCapital = false;
        int capitals = 0;
        if (Character.isUpperCase(chars[0])) {
            capitals++;
            firstIsCapital = true;
        }
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(chars[i])) {
                capitals++;
            }
        }

        return (firstIsCapital && capitals == 1) || capitals == word.length() || capitals == 0;
    }

    /**
     * 对于字符串模式匹配的问题，都可以考虑用正则表达式求解。
     * @param word 待检测字符串
     * @return  是否符合规则
     */
    public boolean detectCapitalsUse2(String word) {
        return word.matches("[A-Z]*|[A-Z]?[a-z]*");
    }
}
