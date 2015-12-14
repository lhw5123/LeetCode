package com.hevin.sort;

/**
 * 低位优先的字符串排序
 */
public class LCD {
    /**
     * 低位优先字符串排序
     * @param strs  字符串数组
     * @param w     通过前w个字符进行排序
     */
    public static void sort(String[] strs, int w) {
        int len = strs.length;
        int R = 256;
        String[] aux = new String[len];
        for (int d = w - 1; d >= 0; d--) {
            int[] count = new int[R + 1];   // 计算出现频率
            for (String str : strs) {
                count[str.charAt(d) + 1]++;
            }
            for (int r = 0; r < R; r++) {   // 将频率转换为索引
                count[r + 1] += count[r];
            }
            for (String str : strs) {
                aux[count[str.charAt(d)]++] = str;  // 将元素分类
            }
            System.arraycopy(aux, 0, strs, 0, len);
        }
    }
}
