package com.hevin.sort;

/**
 * 高位优先的字符串排序
 */
public class MSD {
    private static int R = 256;
    private static final int M = 15;
    private static String[] aux;

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        }
        return -1;
    }

    public static void sort(String[] a) {
        int len = a.length;
        aux = new String[len];
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + M) {
        }
    }
}
