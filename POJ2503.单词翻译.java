/*
 * 输入：输入包含最多 100,000 个字典条目，每个字典条目都包含英文单词、空格和外文单词，后跟一个空格。
 * 接下来是待翻译的消息，最多 100,000 个外语单词（每行一个）。字典中外语单词不会重复出现。
 * 每个单词最多有 10 个小写字母。
 * 
 * 输出：输出翻译好的英语消息，每行一个单词，将不在字典中的外来词翻译成“eh”。
 */

// 算法设计：
// 1. 将字典条目中的英文单词存储到数组中，讲英语单词插入字典树中。
// 2. 从字典树中查找待翻译的外语单词，输出对应的英文单词。

class Solution {
    private int[][] trie;
    private int tot;

    void insert(String s, int k) {
        int len = s.length(), p = 1;
        for (int i = 0; i < len; i++) {
            int ch = s.charAt(i) - 1;
            if (trie[p][ch] > 0) {
                trie[p][ch] = ++tot;
            }
        }
    }
}